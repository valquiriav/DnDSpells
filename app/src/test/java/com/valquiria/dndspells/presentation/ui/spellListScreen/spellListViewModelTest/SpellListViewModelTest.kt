package com.valquiria.dndspells.presentation.ui.spellListScreen.spellListViewModelTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.valquiria.dndspells.data.remote.exception.SpellException
import com.valquiria.dndspells.data.remote.response.SpellItemResponse
import com.valquiria.dndspells.domain.usecase.GetSpellListUseCase
import com.valquiria.dndspells.presentation.ui.SpellAction
import com.valquiria.dndspells.presentation.ui.viewModel.SpellListViewModel
import com.valquiria.dndspells.presentation.ui.spellListScreen.Stub
import com.valquiria.dndspells.presentation.ui.spellListScreen.mock
import com.valquiria.dndspells.presentation.ui.spellListScreen.toSingle
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

abstract class SpellListViewModelTest<S, VM: SpellListViewModel>() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @InjectMockKs
    lateinit var viewModel: VM

    protected val observerStatus: Observer<S> = mock()
    protected val observerLoading: Observer<Boolean> = mock()
    protected val observerAction: Observer<SpellAction> = mock()

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

//        viewModel.observableStatus.observeForever(observerStatus)
//        viewModel.observableLoading.observeForever(observerLoading)
//        viewModel.observableAction.observeForever(observerAction)
    }

    //declara variável que vamos usar
    @MockK
    lateinit var useCase: GetSpellListUseCase

    @Test
    fun shouldGetSpellData() {
        //condição de sucesso do teste
        every { useCase.getSpells() } returns Stub.getSpells().toSingle()

        //simula uma ação
        viewModel.getSpells()

        //verifica a ordem
        Mockito.inOrder(observerLoading, observerStatus).run {
//            verify(observerStatus).onChanged(Stub.getSpells())
        }
    }

    @Test
    fun shouldSendActionErrorWhenGenericErrorOccurs() {
        every { useCase.getSpells() } returns Single.error(Exception())

        viewModel.getSpells()

        Mockito.inOrder(observerLoading, observerAction).run {
            verify(observerAction).onChanged(SpellAction.GenericError)
        }
    }

    @Test
    fun shouldSendActionNoInternetWhenNotConnected() {
        every { useCase.getSpells() } returns Single.error(SpellException.NoConnection)

        viewModel.getSpells()

        Mockito.inOrder(observerLoading, observerAction).run {
            verify(observerAction).onChanged(SpellAction.NoInternet)
        }
    }
}
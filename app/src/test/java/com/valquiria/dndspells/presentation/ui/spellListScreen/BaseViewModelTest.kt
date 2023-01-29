package com.valquiria.dndspells.presentation.ui.spellListScreen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.valquiria.dndspells.presentation.ui.viewModel.BaseViewModel
import com.valquiria.dndspells.presentation.ui.SpellAction
import io.mockk.impl.annotations.InjectMockKs
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Rule

abstract class BaseViewModelTest<S, VM : BaseViewModel<S>> : BaseUnitTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @InjectMockKs
    lateinit var viewModel: VM

    protected val observerStatus: Observer<S> = mock()
    protected val observerLoading: Observer<Boolean> = mock()
    protected val observerAction: Observer<SpellAction> = mock()

    override fun setup() {
        super.setup()

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        viewModel.observableStatus.observeForever(observerStatus)
        viewModel.observableLoading.observeForever(observerLoading)
        viewModel.observableAction.observeForever(observerAction)
    }
}
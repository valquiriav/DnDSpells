package com.valquiria.dndspells.presentation.ui.spellListScreen.spellListViewModelTest

import com.valquiria.dndspells.data.remote.exception.SpellException
import com.valquiria.dndspells.data.remote.response.Spell
import com.valquiria.dndspells.domain.GetSpellListUseCase
import com.valquiria.dndspells.presentation.ui.SpellAction
import com.valquiria.dndspells.presentation.ui.spellListScreen.BaseViewModelTest
import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListViewModel
import com.valquiria.dndspells.presentation.ui.spellListScreen.Stub
import com.valquiria.dndspells.presentation.ui.spellListScreen.toSingle
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito

internal class AboutViewModelTest : BaseViewModelTest<List<Spell>, SpellListViewModel>() {

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
            verify(observerStatus).onChanged(Stub.getSpells())
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
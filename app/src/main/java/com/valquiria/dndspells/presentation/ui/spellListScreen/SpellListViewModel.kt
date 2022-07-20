package com.valquiria.dndspells.presentation.ui.spellListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valquiria.dndspells.domain.GetSpellListUseCase
import kotlinx.coroutines.launch

class SpellListViewModel(
    private val spellListUseCase: GetSpellListUseCase
): ViewModel() {

    private fun getSpells() = viewModelScope.launch {
        spellListUseCase.execute()
    }

}
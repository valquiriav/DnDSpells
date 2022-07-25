package com.valquiria.dndspells.presentation.ui.spellListScreen

import com.valquiria.dndspells.data.remote.response.Spell
import com.valquiria.dndspells.domain.GetSpellListUseCase
import com.valquiria.dndspells.presentation.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SpellListViewModel(
    private val getSpellListUseCase: GetSpellListUseCase
) : BaseViewModel<List<Spell>>() {

    fun getSpells() {
        getSpellListUseCase.getSpells()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                status.value = it
            }, {
                it.printStackTrace()
            })
    }
}
package com.valquiria.dndspells.presentation.ui.spellListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.valquiria.dndspells.data.remote.response.Spell
import com.valquiria.dndspells.domain.GetSpellListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SpellListViewModel(
    private val getSpellListUseCase: GetSpellListUseCase
) : ViewModel() {

    val status = MutableLiveData<List<Spell>>()
    val observableStatus: LiveData<List<Spell>>
        get() = status

    fun getSpells() {
        getSpellListUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                status.value = it
            }, {
                it.printStackTrace()
            })
    }
}
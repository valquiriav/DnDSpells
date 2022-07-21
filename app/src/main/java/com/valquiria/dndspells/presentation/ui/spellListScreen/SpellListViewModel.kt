package com.valquiria.dndspells.presentation.ui.spellListScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valquiria.dndspells.data.database.entity.SpellEntity
import com.valquiria.dndspells.domain.GetSpellListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class SpellListViewModel(
    private val getSpellListUseCase: GetSpellListUseCase
): ViewModel() {

    fun getSpells() {
        getSpellListUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                       Log.e("Teste", it.toString()) //printa os dados
            }, {
                it.printStackTrace() //printa erro se der
            })
    }

}
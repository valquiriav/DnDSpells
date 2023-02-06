package com.valquiria.dndspells.presentation.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.valquiria.dndspells.data.remote.exception.SpellException
import com.valquiria.dndspells.domain.model.SpellModel
import com.valquiria.dndspells.domain.usecase.GetSpellListUseCase
import com.valquiria.dndspells.presentation.ui.SpellAction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SpellListViewModel(
    private val getSpellListUseCase: GetSpellListUseCase
) : ViewModel() {

    private val status = MutableLiveData<List<SpellModel>>()
    val observableStatus: LiveData<List<SpellModel>>
        get() = status

    private val action = MutableLiveData<SpellAction>()

    fun getSpells() {
        getSpellListUseCase.getSpells()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                status.value = it
            }, {
                when (it) {
                    is SpellException.NoConnection -> action.value = SpellAction.NoInternet
                    else -> action.value = SpellAction.GenericError
                }
            })
    }
}
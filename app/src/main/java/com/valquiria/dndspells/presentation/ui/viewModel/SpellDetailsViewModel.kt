package com.valquiria.dndspells.presentation.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.valquiria.dndspells.data.remote.exception.SpellException
import com.valquiria.dndspells.domain.model.SpellModel
import com.valquiria.dndspells.domain.usecase.GetSpellDetailsUseCase
import com.valquiria.dndspells.presentation.ui.SpellAction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SpellDetailsViewModel(
    private val getSpellDetailsUseCase: GetSpellDetailsUseCase
) : ViewModel() {

    private val action = MutableLiveData<SpellAction>()
    val observableAction: LiveData<SpellAction> = action

    private val loading = MutableLiveData(false)
    val observableLoading: LiveData<Boolean> = loading

    private val status = MutableLiveData<SpellModel>()
    val observableStatus: LiveData<SpellModel>
        get() = status

    private fun showLoading() {
        loading.value = true
    }

    private fun hideLoading() {
        loading.value = false
    }

    fun getSpellDetails(index: String) {
        getSpellDetailsUseCase.getSpellDetails(index)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { showLoading() }
            .doFinally { hideLoading() }
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
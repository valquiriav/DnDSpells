package com.valquiria.dndspells.presentation.ui.viewModel

import com.valquiria.dndspells.data.remote.exception.SpellException
import com.valquiria.dndspells.domain.model.SpellInfoModel
import com.valquiria.dndspells.domain.usecase.GetSpellDetailsUseCase
import com.valquiria.dndspells.presentation.ui.SpellAction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SpellDetailsViewModel(
    private val getSpellDetailsUseCase: GetSpellDetailsUseCase
) : BaseViewModel<SpellInfoModel>() {

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
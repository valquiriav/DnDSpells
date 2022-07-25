package com.valquiria.dndspells.presentation.ui

sealed class SpellAction {
    object GenericError : SpellAction()
    object NoInternet : SpellAction()
    object NotFoundData : SpellAction()
}
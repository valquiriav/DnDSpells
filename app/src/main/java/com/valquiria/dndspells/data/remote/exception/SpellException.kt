package com.valquiria.dndspells.data.remote.exception

import java.io.IOException

sealed class SpellException : Exception() {
    object NoConnection : IOException()
}
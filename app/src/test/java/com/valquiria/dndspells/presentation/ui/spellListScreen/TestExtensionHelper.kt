package com.valquiria.dndspells.presentation.ui.spellListScreen

import io.reactivex.Single
import org.mockito.Mockito

fun <T> Any.toSingle(): Single<T> {
    return Single.just(this as T)
}

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)
package com.valquiria.dndspells.presentation.ui.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

internal fun <T> Fragment.onObserver(liveData: LiveData<T>, observer: Observer<T>) =
    liveData.observe(viewLifecycleOwner, observer)
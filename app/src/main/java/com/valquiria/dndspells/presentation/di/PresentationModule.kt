package com.valquiria.dndspells.presentation.di

import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListViewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule() : Module {
        return module {
            factory { SpellListViewModel(get()) }
        }
    }
}
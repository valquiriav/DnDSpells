package com.valquiria.dndspells.di

import com.valquiria.dndspells.domain.GetSpellListUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }


    fun useCaseModule(): Module {
        return module {
            factory { GetSpellListUseCase(get()) }
        }
    }
}
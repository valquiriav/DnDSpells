package com.valquiria.dndspells

import android.app.Application
import com.valquiria.dndspells.data.di.DataModule
import com.valquiria.dndspells.domain.di.DomainModule
import com.valquiria.dndspells.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SpellApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SpellApplication)
        }

        PresentationModule.load()
        DataModule.load() //conexão http e o gson (o objeto a partir do json)
        DomainModule.load()
    }
}
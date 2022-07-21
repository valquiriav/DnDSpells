package com.valquiria.dndspells

import android.app.Application
import com.valquiria.dndspells.di.DataModule
import com.valquiria.dndspells.di.DomainModule
import com.valquiria.dndspells.di.PresentationModule
import com.valquiria.dndspells.di.Provides
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SpellApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SpellApplication)
            modules(Provides.dataModule() + Provides.domainModule() + Provides.presentationModule())
        }

        //PresentationModule.load()
        //DataModule.load()
        //DomainModule.load()
    }
}
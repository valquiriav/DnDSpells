package com.valquiria.dndspells.presentation.app

import android.app.Application
import com.valquiria.dndspells.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SpellApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SpellApplication)
            modules(AppModules.dataModule() + AppModules.domainModule() + AppModules.presentationModule())
        }

    }
}
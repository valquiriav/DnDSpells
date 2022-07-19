package com.valquiria.dndspells.data.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.valquiria.dndspells.core.Constants.BASE_URL
import com.valquiria.dndspells.data.remote.SpellsApi
import com.valquiria.dndspells.data.repository.SpellRepository
import com.valquiria.dndspells.data.repository.SpellRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    private const val OK_HTTP = "Ok Http"

    private val gson: Gson by lazy { GsonBuilder().create() }

    fun load() {
        loadKoinModules(spellModule() + networkModule())
    }

    private fun spellModule(): Module {
        return module {
            single<SpellRepository> {
                SpellRepositoryImpl(get(), get())
            }
        }
    }

    private fun networkModule(): Module {
        return module {

            single {
                createOkHttpClient()
            }

            single {
                createService<SpellsApi>(get())
            }

        }
    }

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor {
            Log.e(OK_HTTP, it)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private inline fun <reified T> createService(
        client: OkHttpClient
    ): T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(T::class.java)
    }
}
package com.valquiria.dndspells.di

import androidx.room.Room
import com.valquiria.dndspells.BuildConfig
import com.valquiria.dndspells.Constants.BASE_URL
import com.valquiria.dndspells.data.database.SpellDatabase
import com.valquiria.dndspells.data.database.dao.SpellDao
import com.valquiria.dndspells.data.remote.SpellsApi
import com.valquiria.dndspells.data.repository.SpellRepository
import com.valquiria.dndspells.data.repository.SpellRepositoryImpl
import com.valquiria.dndspells.domain.GetSpellListUseCase
import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Provides {

    fun dataModule() = module {

        factory {
            OkHttpClient.Builder().apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }
            }.build()
        }

        factory<SpellsApi> {
        //prove instancia da interface do retrofit
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SpellsApi::class.java)
        }

        factory<SpellDao> {
            Room.databaseBuilder(androidContext(), SpellDatabase::class.java, "SpellDatabase")
                .allowMainThreadQueries()
                .build()
                .spellDao()
        }

        factory<SpellRepository> {
            SpellRepositoryImpl(get(), get())
        }
    }

    fun domainModule() = module {

        factory {
            GetSpellListUseCase(get())
        }

    }

    fun presentationModule() = module {

        viewModel {
            SpellListViewModel(get())
        }
    }

}
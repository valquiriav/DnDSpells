package com.valquiria.dndspells.di

import androidx.room.Room
import com.valquiria.dndspells.BuildConfig
import com.valquiria.dndspells.Constants.BASE_URL
import com.valquiria.dndspells.data.api.SpellsApi
import com.valquiria.dndspells.data.local.SpellDatabase
import com.valquiria.dndspells.data.repository.RepositoryImpl
import com.valquiria.dndspells.domain.repository.Repository
import com.valquiria.dndspells.domain.usecase.GetSpellDetailsUseCase
import com.valquiria.dndspells.domain.usecase.GetSpellListUseCase
import com.valquiria.dndspells.presentation.ui.viewModel.SpellDetailsViewModel
import com.valquiria.dndspells.presentation.ui.viewModel.SpellListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {

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
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SpellsApi::class.java)
        }

        factory {
            Room.databaseBuilder(
                androidContext(),
                SpellDatabase::class.java,
                "SpellDatabase"
            )
                .allowMainThreadQueries()
                .build()
                .spellDao()
        }

        factory<Repository> {
            RepositoryImpl(get())
        }
    }

    fun domainModule() = module {

        factory { GetSpellListUseCase(get()) }
        factory { GetSpellDetailsUseCase(get()) }

    }

    fun presentationModule() = module {

        viewModel { SpellListViewModel(get()) }
        viewModel { SpellDetailsViewModel(get()) }
    }

}
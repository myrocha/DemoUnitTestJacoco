package com.example.workshoptest.di


import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.workshoptest.coroutine.CoroutineProvider
import com.example.workshoptest.model.mapper.UserMapper
import com.example.workshoptest.model.persistence.AppDatabase
import com.example.workshoptest.model.persistence.UserDao
import com.example.workshoptest.repository.LoginRepository
import com.example.workshoptest.repository.MainRepository
import com.example.workshoptest.repository.RegisterRepository
import com.example.workshoptest.service.LoginService
import com.example.workshoptest.viewmodel.LoginViewlModel
import com.example.workshoptest.viewmodel.MainViewModel
import com.example.workshoptest.viewmodel.RegisterViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.sin


private const val TIMEOUT_MINUTES = 1L
private const val TIMEOUT_SECONDS = 30L

val networkModule = module {

    single { provideRetrofit() }

    /**
     * pedimos ao koin para que ele nos forneca
     * uma instancia do retrofit e a partir dela, queremos
     * que ele crie pra gente a instamcia do service de login
     */
    factory { get<Retrofit>().create(LoginService::class.java) }

}


val loginViewModelModule = module {
    single { provideLoginRepository(get()) }

    single { provideCoroutineProvider() }

    viewModel { LoginViewlModel(get(), get()) }
}


val registerViewModelModule = module {
    single { provideRegisterRepository(get(), get()) }

    viewModel { RegisterViewModel(get(), get()) }
}

val mainViewModelModule = module {
    single { provideMainRepository(get(), get()) }
    viewModel { MainViewModel(get(), get()) }
}


val databaseModule = module {
    /**
     * fornece a instancia de appdatabase
     */
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            "user-database"
        ).fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().userDao() }

}

val mapperModule = module {
    factory {
        UserMapper()
    }
}

fun provideRetrofit() = Retrofit.Builder().baseUrl("http://10.27.164.61:3000/api/")
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(
        OkHttpClient().newBuilder()
            .connectTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS).build()
    ).addConverterFactory(GsonConverterFactory.create()).build()

fun provideLoginRepository(api: LoginService) =
    LoginRepository(api)

fun provideCoroutineProvider() = CoroutineProvider()

fun provideRegisterRepository(userDao: UserDao, coroutineProvider: CoroutineProvider) = RegisterRepository(userDao)

fun provideMainRepository(userDao: UserDao, coroutineProvider: CoroutineProvider) = MainRepository(userDao)
package rs.raf.ognjenradovic.modules

import JobRepositoryImpl
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rs.raf.ognjenradovic.BuildConfig
import rs.raf.ognjenradovic.data.datasources.local.JobDataBase
import rs.raf.ognjenradovic.data.datasources.remote.JobService
import rs.raf.ognjenradovic.data.repositories.JobRepository
import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.MainViewModel
import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.SecondViewModel
import java.util.*
import java.util.concurrent.TimeUnit

val coreModule = module(override = true) {

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(androidApplication().packageName, Context.MODE_PRIVATE)
    }

    single { Room.databaseBuilder(androidContext(), JobDataBase::class.java, "JobsDb")
        .fallbackToDestructiveMigration()
        .build() }

    single { createJobRetrofit(moshi = get(), httpClient = get()) }
    single { createMoshi() }
    viewModel { MainViewModel(jobRepository=get()) }
    viewModel { SecondViewModel(jobRepository=get()) }


    single { createOkHttpClient() }
    single<JobRepository> { JobRepositoryImpl(localDataSource = get(), remoteDataSource = get()) }
    single { get<JobDataBase>().getJobDao() }
    single<JobService> { create(retrofit = get()) }

}

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()
}

fun createJobService(retrofit: Retrofit): JobService {
    return retrofit.create(JobService::class.java)
}

fun createJobRetrofit(moshi: Moshi, httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://c051d8b188ea43ac9680529542d1dd51.api.mockbin.io/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .client(httpClient)
        .build()
}

fun createOkHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.readTimeout(60, TimeUnit.SECONDS)
    httpClient.connectTimeout(60, TimeUnit.SECONDS)
    httpClient.writeTimeout(60, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
    }

    return httpClient.build()
}

// Metoda koja kreira servis
inline fun <reified T> create(retrofit: Retrofit): T  {
    return retrofit.create(T::class.java)
}

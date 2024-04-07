package rs.raf.ognjenradovic.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import rs.raf.ognjenradovic.modules.coreModule
import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.SecondViewModel
//import io.ktor.client.*
//import io.ktor.client.engine.cio.*
//import io.ktor.client.request.*
//import io.ktor.client.statement.*

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initTimber()
        initKoin()
    }


//    suspend fun main() {
//        val client = HttpClient(CIO)
//        val response: HttpResponse = client.get("https://ktor.io/")
//        println(response.status)
//        client.close()
//    }

    private fun initTimber() {
        //Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {

        val modules = listOf(
            coreModule
        )
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            androidFileProperties()
            fragmentFactory()
            modules(modules)
        }
    }

}
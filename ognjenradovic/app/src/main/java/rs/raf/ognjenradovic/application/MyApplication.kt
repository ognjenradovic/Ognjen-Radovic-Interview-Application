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
import rs.raf.ognjenradovic.modules.mealsModule
import rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel.SecondViewModel

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        //Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {

        val modules = listOf(
            coreModule, mealsModule
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
package training.jcdy.numeriqapp

import android.app.Application
import org.koin.core.context.startKoin
import training.jcdy.numeriqapp.di.applicationModule


class NumeriQApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(*applicationModule)
        }
    }
}
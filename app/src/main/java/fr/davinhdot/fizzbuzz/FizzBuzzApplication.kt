package fr.davinhdot.fizzbuzz

import android.app.Application
import timber.log.Timber

class FizzBuzzApplication : Application() {

    override fun onCreate() {
        Timber.d("onCreate")

        super.onCreate()

        initTimber()
    }

    private fun initTimber() {

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
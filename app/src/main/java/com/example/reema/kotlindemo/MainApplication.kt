package com.example.reema.kotlindemo

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MainApplication : Application(),HasActivityInjector{

    @Inject
    lateinit var activityDispatchingAndroidInjector:
            DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
//
//        DaggerAppComponent.builder()
//                .application(this)
//                .build()
//                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
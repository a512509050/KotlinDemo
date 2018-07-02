package com.digg.kotlindemo.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.digg.kotlindemo.di.module.MainModule

import com.jess.arms.di.scope.ActivityScope
import com.digg.kotlindemo.mvp.ui.activity.MainActivity

/**
 * <pre>
 * @author : Lvyan
 * Description : MainComponent
 * Date : 2018-7-2 14:42:33
 * </pre>
 */
@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}

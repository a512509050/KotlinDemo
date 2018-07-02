package com.digg.kotlindemo.di.component

import com.digg.kotlindemo.di.module.LoginModule
import com.digg.kotlindemo.mvp.ui.activity.LoginActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * <pre>
 * @author : Lvyan
 * Description : LoginComponent
 * Date : 2018-6-27 15:58:31
 * </pre>
 */
@ActivityScope
@Component(modules = arrayOf(LoginModule::class), dependencies = arrayOf(AppComponent::class))
interface LoginComponent {
    fun inject(activity: LoginActivity)
}

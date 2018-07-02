package com.digg.kotlindemo.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.digg.kotlindemo.di.module.GirlsModule

import com.jess.arms.di.scope.FragmentScope
import com.digg.kotlindemo.mvp.ui.fragment.GirlsFragment

/**
 * <pre>
 * @author : Lvyan
 * Description : GirlsComponent
 * Date : 2018-7-2 15:22:15
 * </pre>
 */
@FragmentScope
@Component(modules = arrayOf(GirlsModule::class), dependencies = arrayOf(AppComponent::class))
interface GirlsComponent {
    fun inject(fragment: GirlsFragment)
}

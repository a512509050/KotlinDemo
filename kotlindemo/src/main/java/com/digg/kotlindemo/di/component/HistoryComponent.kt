package com.digg.kotlindemo.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.digg.kotlindemo.di.module.HistoryModule

import com.jess.arms.di.scope.FragmentScope
import com.digg.kotlindemo.mvp.ui.fragment.HistoryFragment

/**
 * <pre>
 * @author : Lvyan
 * Description : HistoryComponent
 * Date : 2018-7-2 15:22:37
 * </pre>
 */
@FragmentScope
@Component(modules = arrayOf(HistoryModule::class), dependencies = arrayOf(AppComponent::class))
interface HistoryComponent {
    fun inject(fragment: HistoryFragment)
}

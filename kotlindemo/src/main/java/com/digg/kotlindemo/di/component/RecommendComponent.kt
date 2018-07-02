package com.digg.kotlindemo.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.digg.kotlindemo.di.module.RecommendModule

import com.jess.arms.di.scope.FragmentScope
import com.digg.kotlindemo.mvp.ui.fragment.RecommendFragment

/**
 * <pre>
 * @author : Lvyan
 * Description : RecommendComponent
 * Date : 2018-7-2 15:20:43
 * </pre>
 */
@FragmentScope
@Component(modules = arrayOf(RecommendModule::class), dependencies = arrayOf(AppComponent::class))
interface RecommendComponent {
    fun inject(fragment: RecommendFragment)
}

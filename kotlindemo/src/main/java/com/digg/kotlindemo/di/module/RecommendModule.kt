package com.digg.kotlindemo.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.digg.kotlindemo.mvp.contract.RecommendContract
import com.digg.kotlindemo.mvp.model.RecommendModel

/**
 * <pre>
 * @author : Lvyan
 * Description : RecommendModule
 * Date : 2018-7-2 15:20:43
 * </pre>
 */
@Module
//构建RecommendModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class RecommendModule(private val view: RecommendContract.View) {
    @FragmentScope
    @Provides
    fun provideRecommendView(): RecommendContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideRecommendModel(model: RecommendModel): RecommendContract.Model {
        return model
    }
}

package com.digg.kotlindemo.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.digg.kotlindemo.mvp.contract.HistoryContract
import com.digg.kotlindemo.mvp.model.HistoryModel

/**
 * <pre>
 * @author : Lvyan
 * Description : HistoryModule
 * Date : 2018-7-2 15:22:37
 * </pre>
 */
@Module
//构建HistoryModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class HistoryModule(private val view: HistoryContract.View) {
    @FragmentScope
    @Provides
    fun provideHistoryView(): HistoryContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideHistoryModel(model: HistoryModel): HistoryContract.Model {
        return model
    }
}

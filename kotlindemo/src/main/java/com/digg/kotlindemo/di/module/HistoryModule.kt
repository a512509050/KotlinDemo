package com.digg.kotlindemo.di.module

import com.digg.kotlindemo.mvp.contract.HistoryContract
import com.digg.kotlindemo.mvp.model.HistoryModel
import com.digg.kotlindemo.mvp.model.entity.History
import com.digg.kotlindemo.mvp.ui.adapter.HistoryAdapter
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

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
    fun provideHistoryView(): HistoryContract.View = this.view

    @FragmentScope
    @Provides
    fun provideHistoryModel(model: HistoryModel): HistoryContract.Model = model

    @FragmentScope
    @Provides
    fun provideData() = mutableListOf<History>()

    @FragmentScope
    @Provides
    fun provideAdapter(data: MutableList<History>) = HistoryAdapter(data)

}

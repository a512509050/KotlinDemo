package com.digg.kotlindemo.di.module

import com.digg.kotlindemo.mvp.contract.GirlsContract
import com.digg.kotlindemo.mvp.model.GirlsModel
import com.digg.kotlindemo.mvp.model.entity.Article
import com.digg.kotlindemo.mvp.ui.adapter.GirlsAdapter
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * <pre>
 * @author : Lvyan
 * Description : GirlsModule
 * Date : 2018-7-2 15:22:15
 * </pre>
 */
@Module
//构建GirlsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class GirlsModule(private val view: GirlsContract.View) {
    @FragmentScope
    @Provides
    fun provideGirlsView(): GirlsContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideGirlsModel(model: GirlsModel): GirlsContract.Model {
        return model
    }

    @FragmentScope
    @Provides
    fun provideData() = mutableListOf<Article>()

    @FragmentScope
    @Provides
    fun provideAdapter(data: List<Article>): GirlsAdapter = GirlsAdapter(data)

}

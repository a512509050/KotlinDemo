package com.digg.kotlindemo.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.digg.kotlindemo.mvp.contract.GirlsContract
import com.digg.kotlindemo.mvp.model.GirlsModel

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
}

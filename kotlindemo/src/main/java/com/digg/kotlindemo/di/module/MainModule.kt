package com.digg.kotlindemo.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.digg.kotlindemo.mvp.contract.MainContract
import com.digg.kotlindemo.mvp.model.MainModel

/**
 * <pre>
 * @author : Lvyan
 * Description : MainModule
 * Date : 2018-7-2 14:42:33
 * </pre>
 */
@Module
//构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MainModule(private val view: MainContract.View) {
    @ActivityScope
    @Provides
    fun provideMainView(): MainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMainModel(model: MainModel): MainContract.Model {
        return model
    }
}

package com.digg.kotlindemo.mvp.model.entity

/**
 * <pre>
 * @author : Lvyan
 * Description :
 * Date : 2018/7/2 14:23
 * </pre>
 */
data class BaseBean<T>(val error: Boolean, val results: T)
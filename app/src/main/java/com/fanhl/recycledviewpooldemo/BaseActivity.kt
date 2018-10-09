package com.fanhl.recycledviewpooldemo

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 * @author fanhl
 */
abstract class BaseActivity : AppCompatActivity(), IRxLifecycle by RxLifecycleImpl() {
    override fun onDestroy() {
        onRecycle()
        super.onDestroy()
    }
}

interface IRxLifecycle {
    fun onRecycle()
    fun Disposable.bindLifecycle(): Boolean
}

class RxLifecycleImpl : IRxLifecycle {
    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onRecycle() {
        // 全部注销订阅.
        compositeDisposable.dispose()
    }

    override fun Disposable.bindLifecycle() = compositeDisposable.add(this)
}
package com.fanhl.recycledviewpooldemo

import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val adapter by lazy {
        MainAdapter().apply {
            setOnLoadMoreListener({
                loadData(true)
            }, recycler_view)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assignViews()
        refreshData()
    }

    private fun assignViews() {
        swipe_refresh_layout.setOnRefreshListener { refreshData() }
        recycler_view.adapter = adapter
    }

    private fun refreshData() {
        swipe_refresh_layout.post { swipe_refresh_layout.isRefreshing = true }
        adapter.setEnableLoadMore(false)
        loadData()
    }

    private fun loadData(loadMore: Boolean = false) {
        Observable
            .create<List<Post>> {
                Thread.sleep(1000)
                it.onNext(
                    List(10) { Post() }
                )
                it.onComplete()
            }
            .map {
                it.map {
                    MainAdapter.MainItem(
                        1,
                        it
                    )
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                swipe_refresh_layout.post { swipe_refresh_layout.isRefreshing = false }

                if (loadMore) {
                    adapter.addData(it)
                } else {
                    adapter.setNewData(it)
                }

                if (!loadMore) {
                    adapter.setEnableLoadMore(true)
                }

//                if (it.hasNext(page)) {
//                    page++
                adapter.loadMoreComplete()
//                } else {
//                    adapter.loadMoreEnd(false)
//                }
            }
            .bindLifecycle()
    }
}

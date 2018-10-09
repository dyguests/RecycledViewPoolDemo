package com.fanhl.recycledviewpooldemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assignViews()
        refreshData()
    }

    private fun assignViews() {
        swipe_refresh_layout.setOnRefreshListener { refreshData() }
    }

    private fun refreshData() {
    }
}

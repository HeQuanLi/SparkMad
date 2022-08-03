package com.hql.spark.module.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.hql.spark.module.base.BaseActivity
import com.hql.spark.module.main.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.test()
        viewModel.liveDataPageData.observe(this) {
            Log.d("TAG_HQL", "onCreate:${it.datas?.size} ")
        }
    }
}
package com.hql.spark.module.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.hql.spark.module.base.BaseActivity
import com.hql.spark.module.base.launchFlow
import com.hql.spark.module.main.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchFlow({ viewModel.test() }) {
            onSuccess = {
                Log.d("TAG_HQL", "${Thread.currentThread()}")
                Log.d("TAG_HQL", "onCreate: ${it?.datas?.size}")
            }
        }

    }
}
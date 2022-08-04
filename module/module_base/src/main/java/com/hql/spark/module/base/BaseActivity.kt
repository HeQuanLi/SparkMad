package com.hql.spark.module.base

import androidx.appcompat.app.AppCompatActivity
import com.hql.spark.module.base.widget.loading.LoadingDialog

/**
 * @author HQL
 * Created on 2022/4/11
 * Desc:
 */
abstract class BaseActivity : AppCompatActivity(), IView {

    private val loadingDialog: LoadingDialog by lazy { LoadingDialog() }

    override fun showLoading() {
        loadingDialog.show(supportFragmentManager, "")
    }

    override fun dismissLoading() {
        loadingDialog.dismiss()
    }
}
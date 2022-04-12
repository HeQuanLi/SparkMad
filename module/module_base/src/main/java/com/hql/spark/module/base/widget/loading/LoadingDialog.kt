package com.hql.spark.module.base.widget.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.hql.spark.module.base.R

/**
 * @author HQL
 * Created on 2021/12/16
 * Desc:
 */

class LoadingDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return LayoutInflater.from(context)
            .inflate(R.layout.base_common_dialog_loading, container, false)
    }
}
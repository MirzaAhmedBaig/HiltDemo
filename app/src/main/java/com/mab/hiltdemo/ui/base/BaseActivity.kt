package com.mab.hiltdemo.ui.base

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mab.hiltdemo.R
import com.mab.hiltdemo.data.network.Resource
import javax.inject.Inject


/**
 * Created by Mirza Ahmed Baig on 9/1/2020.
 */

abstract class BaseActivity : AppCompatActivity() {
    val TAG: String
        get() = getClassName()

    @Inject
    lateinit var factory: BaseViewModelFactory

    override fun finish() {
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        super.finish()
    }

    fun handleError(error: Resource.Failure) {
        if (error.isNetworkError) {
            Log.e(TAG, "showNetworkErrorDialog")
        } else {
            val msg = error.message ?: "Error : ${error.errorCode} : ${error.errorBody}"
            Log.e(TAG, "msg : $msg")
        }
    }

    abstract fun getClassName(): String
}
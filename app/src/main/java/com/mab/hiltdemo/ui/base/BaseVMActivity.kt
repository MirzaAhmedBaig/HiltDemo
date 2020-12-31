package com.mab.hiltdemo.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.ParameterizedType

abstract class BaseVMActivity<VM : BaseViewModel, B : ViewBinding> : BaseActivity() {

    lateinit var viewModel: VM
    lateinit var binding: B


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(getViewModelClass())
        binding = getViewBinding()
        setContentView(binding.root)
    }

    private fun getViewModelClass(): Class<VM> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }

    abstract fun getViewBinding(): B
}

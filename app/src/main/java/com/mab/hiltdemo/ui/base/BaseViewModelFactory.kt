package com.mab.hiltdemo.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mab.hiltdemo.data.repositories.DataRepository
import javax.inject.Inject

/**
 * Created by Mirza Ahmed Baig on 9/1/2020.
 */

class BaseViewModelFactory @Inject constructor(private val dataRepository: DataRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DataRepository::class.java).newInstance(dataRepository)
    }
}
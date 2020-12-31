package com.mab.hiltdemo.ui.base

import androidx.lifecycle.ViewModel
import com.mab.hiltdemo.data.repositories.DataRepository

abstract class BaseViewModel(val dataRepository: DataRepository) : ViewModel() {
    fun getLoggedInUser() = dataRepository.getUser()


}
package com.mab.hiltdemo.ui.pages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dewise.askus.data.db.entities.User
import com.mab.hiltdemo.data.network.Resource
import com.mab.hiltdemo.data.network.response.SocialLoginResponse
import com.mab.hiltdemo.data.repositories.DataRepository
import com.mab.hiltdemo.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class DemoViewModel(dataRepository: DataRepository) : BaseViewModel(dataRepository) {

    private var _userExistResponse: MutableLiveData<Resource<SocialLoginResponse>> =
        MutableLiveData()
    val userExistResponse: LiveData<Resource<SocialLoginResponse>>
        get() = _userExistResponse

    fun isUserExist(email: String) = viewModelScope.launch {
        _userExistResponse.value = dataRepository.isUserExist(email)
    }

    fun saveLoggedInUser(user: User) = viewModelScope.launch {
        dataRepository.saveUser(user)
    }
}
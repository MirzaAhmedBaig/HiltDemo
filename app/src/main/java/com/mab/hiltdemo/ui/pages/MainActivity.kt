package com.mab.hiltdemo.ui.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import com.dewise.askus.data.db.entities.User
import com.google.gson.Gson
import com.mab.hiltdemo.R
import com.mab.hiltdemo.databinding.ActivityMainBinding
import com.mab.hiltdemo.ui.base.BaseVMActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseVMActivity<DemoViewModel, ActivityMainBinding>() {


    override fun getClassName(): String = MainActivity::class.java.simpleName
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListeners()
        observeUser()

        viewModel.userExistResponse.observe(this, Observer {
            it.checkResponse(onSuccess = {
                viewModel.saveLoggedInUser(
                    User(
                        "",
                        "m@a.com",
                        "mirza",
                        1,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        1,
                        ""
                    )
                )
            }, onError = {
                handleError(it)
            })
        })

        viewModel.isUserExist("mirza@avantari.org")
    }

    private fun setListeners() {
        binding.startButton.setOnClickListener {
            viewModel.isUserExist("mirza@avantari.org")
        }
    }


    private fun observeUser() {
        viewModel.getLoggedInUser().observe(this, Observer {
            Log.e(TAG, "Called observeUser ${Gson().toJson(it)}")
        })
    }
}
package com.mab.hiltdemo.data.network

open class BaseResponse() {
    var success: Boolean = false
    var responseCode: String = ""
    var message: String = ""
    var AccessToken: String = ""
    var Role: Int = -1
}
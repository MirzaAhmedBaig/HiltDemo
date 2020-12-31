package com.mab.hiltdemo.data.network.response

import com.mab.hiltdemo.data.network.BaseResponse


data class SocialLoginResponse(
        val HaveAccount: Boolean,
        val LetHimLogin: Boolean,
        val ID: String,
        val UserInfo: UserInfo
) : BaseResponse()

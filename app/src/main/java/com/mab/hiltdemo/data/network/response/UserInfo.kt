package com.mab.hiltdemo.data.network.response

data class UserInfo(
        val RoleId: String,
        val RoleName: String,
        val UserId: String,
        val UserName: String,
        val FullName: String,
        val CountryId: String,
        val TimeZoneAppId: String,
        val Gender: Int,
        val PicUrl: String,
        val Mobile: Long
)
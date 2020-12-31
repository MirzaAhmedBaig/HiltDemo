package com.dewise.askus.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User(
        var userId: String,
        var email: String,
        var name: String,
        var gender: Int,
        var mobileNumber: String?,
        var userPicUrl: String,
        var countryId: String,
        var timezoneAppId: String,
        var roleId: String,
        var roleName: String,
        var role: Int,
        var fcmToken: String?
) {
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}
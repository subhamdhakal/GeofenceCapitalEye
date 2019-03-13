package com.example.capitaleyegeofence

import android.content.Context
import android.content.SharedPreferences
import java.lang.Error
import java.security.AccessControlContext

class AppPreferences(context: Context) {

    private var preferences: SharedPreferences = context.getSharedPreferences("capitaleye", Context.MODE_PRIVATE)

    var userName: String
    get() = preferences.getString("user_name", "User")
    set(data) = preferences.edit().putString("user_name", data).apply()


}
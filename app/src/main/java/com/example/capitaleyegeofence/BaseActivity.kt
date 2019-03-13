package com.example.capitaleyegeofence

import android.support.v7.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(){
    fun getRepository()=(application as App).getRepository()

}
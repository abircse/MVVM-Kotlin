package com.example.mvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {

    // this method is use for when login operation started
    fun onStarted()
    // this method is use for when login operation Success
    fun onSuccess(loginResponseFromUserRepository: LiveData<String>)
    // this method is use for when login operation failure
    fun onFailure(message:String)
}
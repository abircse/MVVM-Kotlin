package com.example.mvvmsampleapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.databinding.ActivityLoginBinding
import com.example.mvvmsampleapp.util.hide
import com.example.mvvmsampleapp.util.myToast
import com.example.mvvmsampleapp.util.show
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // we use data bindind insted of setcontent view with will auto create a new name of Loginactivtyclass
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        // Now we have to call viewmodel here with viewmodel class name in get method
        var viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        // Now we set this view model to our binding viewmodel
        binding.viewmodel = viewModel
        // set authlister to our view model
        viewModel.authListener = this
    }

    override fun onStarted()
    {
        progressBar.show()
        myToast("Login Started")

    }

    override fun onSuccess(loginResponseFromUserRepository: LiveData<String>)
    {
        loginResponseFromUserRepository.observe(this, Observer
        {
            progressBar.hide()
            myToast(it)
        })
    }

    override fun onFailure(message: String)
    {
        progressBar.hide()
        myToast(message)

    }



}

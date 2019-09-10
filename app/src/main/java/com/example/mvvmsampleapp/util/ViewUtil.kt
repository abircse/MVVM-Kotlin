package com.example.mvvmsampleapp.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

// functions to show show
fun Context.myToast(message: String)
{
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

// Functions to show progressbar
fun ProgressBar.show(){

    visibility = View.VISIBLE
}

// Functions to hide Progressbar
fun ProgressBar.hide(){

    visibility = View.GONE
}
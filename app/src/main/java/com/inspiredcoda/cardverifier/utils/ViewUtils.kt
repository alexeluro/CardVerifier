package com.inspiredcoda.cardverifier.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun ProgressBar.show(){
    this.visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    this.visibility = View.GONE
}

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
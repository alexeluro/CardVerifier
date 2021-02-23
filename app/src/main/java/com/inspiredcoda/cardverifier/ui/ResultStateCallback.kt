package com.inspiredcoda.cardverifier.ui

interface ResultStateCallback {

    fun onLoading()

    fun onSuccess(message: String?)

    fun onFailure(message: String?)

}
package com.inspiredcoda.cardverifier.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import com.inspiredcoda.cardverifier.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor(private val context: Context): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        if (isInternetAvailable()){
            throw NoInternetException("Check you Internet Connection and try again")
        }
        return chain.proceed(chain.request())
    }

    private fun isInternetAvailable(): Boolean {

        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        manager.activeNetworkInfo.let {
            return it != null && it.isConnectedOrConnecting
        }
    }

}
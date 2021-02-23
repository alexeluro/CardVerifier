package com.inspiredcoda.cardverifier.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredcoda.cardverifier.data.repository.MainRepository
import com.inspiredcoda.cardverifier.data.response.CardDetailsResponse
import com.inspiredcoda.cardverifier.utils.ApiException
import com.inspiredcoda.cardverifier.utils.NoInternetException
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
        private val repository: MainRepository
): ViewModel() {

    private var _cardDetails = MutableLiveData<CardDetailsResponse>()
    val cardDetailsLive: LiveData<CardDetailsResponse>
        get() = _cardDetails


    fun setCardDetails(serials: String, callback: ResultStateCallback){
        viewModelScope.launch {
            try {
                callback.onLoading()
                _cardDetails.postValue(repository.getCardDetails(serials))
                callback.onSuccess("checked successfully...")
            }catch (e: NoInternetException){
                callback.onFailure(e.message)
            }catch (e: ApiException){
                callback.onFailure(e.message)
            }
        }
    }

}
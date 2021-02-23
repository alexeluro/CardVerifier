package com.inspiredcoda.cardverifier.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import com.inspiredcoda.cardverifier.R
import com.inspiredcoda.cardverifier.data.response.CardDetailsResponse
import com.inspiredcoda.cardverifier.utils.hide
import com.inspiredcoda.cardverifier.utils.show
import com.inspiredcoda.cardverifier.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ResultStateCallback {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observer()

        main_serial_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(value: Editable?) {
                if ((!value.isNullOrEmpty()) && value.toString().length > 3){
                    mainViewModel.setCardDetails(value.toString(), this@MainActivity)
                }
            }
        })

    }

    private fun setValues(cardResponse: CardDetailsResponse){
        main_bank_text.text = cardResponse.bank?.name ?: ""
        main_card_number_length_text.text = cardResponse.number?.length.toString()
        main_card_scheme_text.text = cardResponse.scheme ?: ""
        main_card_type.text = cardResponse.type ?: ""
        main_country.text = cardResponse.country?.name ?: ""
        main_prepaid_text.text = if (cardResponse.prepaid) "Yes" else "No"
    }

    private fun observer(){
        mainViewModel.cardDetailsLive.observe(this){
            if (it != null){
                setValues(it)
            }
        }
    }

    override fun onLoading() {
        main_progress_bar.show()
    }

    override fun onSuccess(message: String?) {
        main_progress_bar.hide()
        if (!message.isNullOrEmpty())
            toast(message)
    }

    override fun onFailure(message: String?) {
        main_progress_bar.hide()
        toast(message ?: "")
    }

}
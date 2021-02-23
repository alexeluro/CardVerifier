package com.inspiredcoda.cardverifier.ui

import com.google.common.truth.Truth.assertThat
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityTest {


    @Test
    fun properlySeparate_5_Digit_Serials() {
        val result = separateCardNumber("45713")

        assertEquals("4571 3", result)
    }

    @Test
    fun undoProperlySeparate_5_Digit_Serials() {
        val result = undoCardNumberSeparation("4571 3")

        assertEquals("45713", result)
    }

    @Test
    fun properlySeparate_6_Digit_Serials() {
        val result = separateCardNumber("457134")

        assertEquals("4571 34", result)
    }

    @Test
    fun undoProperlySeparate_6_Digit_Serials() {
        val result = undoCardNumberSeparation("4571 34")

        assertEquals("457134", result)
    }

    @Test
    fun properlySeparate_9_Digit_Serials() {
        val result = separateCardNumber("457134789")

        assertEquals("4571 3478 9", result)
    }

    @Test
    fun undoProperlySeparate_9_Digit_Serials() {
        val result = undoCardNumberSeparation("4571 3478 9")

        assertEquals("457134789", result)
    }

    fun separateCardNumber(serials: String): String {
        var newSerial = StringBuilder()
        for (x in serials.indices) {
            if (x % 4 == 0 && x != 0) {
                newSerial.append(" ${serials[x]}")
            } else {
                newSerial.append(serials[x])
            }
        }
        return newSerial.toString()
    }

    fun undoCardNumberSeparation(spacedSerials: String): String{
        val result = StringBuilder()
        for (x in spacedSerials.indices){
            if (spacedSerials[x].toString() != " "){
                result.append(spacedSerials[x])
            }
        }
        return result.toString()
    }

}
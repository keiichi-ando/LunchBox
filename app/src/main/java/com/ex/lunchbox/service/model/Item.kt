package com.ex.lunchbox.service.model

import android.net.Uri

data class Item(
    val dateLabel: String,
    val isHoliday: Boolean,
    val status: String
) {
    fun imageUrl(): String {
        return "http://172.16.1.17:8000/assets/images/" + dateLabel.replace("/", "").substring(0,4) + ".png"
//        return "http://172.16.1.17:8000/assets/images/0901.png"
    }
}
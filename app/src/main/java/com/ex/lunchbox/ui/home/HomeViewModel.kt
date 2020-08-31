package com.ex.lunchbox.ui.home

import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ex.lunchbox.service.model.Item
import java.text.SimpleDateFormat
import java.util.*
import java.util.Date as Date

class HomeViewModel : ViewModel() {

    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,          // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    enum class ProcessState {
        DO,
        RESERVED,
        CANCELED
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val workList = MutableLiveData<List<Item>>()

    @UiThread
    fun getWorkList(): LiveData<List<Item>> = workList

    @UiThread
    fun initList() {
        workList.value = emptyList()
    }

    @UiThread
    fun loadList() {
        val list: MutableList<Item> = mutableListOf()
        val calendar = Calendar.getInstance()
        val date = Date()
        val sdf = SimpleDateFormat("MM/dd (EEE)", Locale.JAPANESE)
        var weekday: Int = 0

        calendar.setTime(date)

        for (i in 0..20) {
            weekday = calendar.get(Calendar.DAY_OF_WEEK)
            list.add(Item(sdf.format(calendar.getTime()), (weekday == 1 || weekday == 7), weekday.toString()))
            calendar.add(Calendar.DATE, 1)
        }
        workList.value = list
    }
}
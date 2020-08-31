package com.ex.lunchbox.ui.home

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ex.lunchbox.R

object CustomBindingAdapter {

    @BindingAdapter("highLight")
    @JvmStatic
    fun setHighlight(view: View, statusCode: String?) {
        when (statusCode) {
            "1", "7" -> {
                view.setBackgroundResource(R.color.cardStateDisabled)
            }
            else -> {
                view.setBackgroundResource(R.color.cardStateNormal)
            }
        }
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun ImageView.setImage(uri: String?){
        Glide.with(this)
            .load(uri)
            .into(this)
    }
}

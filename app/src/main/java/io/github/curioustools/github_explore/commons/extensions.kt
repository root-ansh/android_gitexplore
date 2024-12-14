package io.github.curioustools.github_explore.commons

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import io.github.curioustools.github_explore.R

fun MaterialButton.updateState(selected: Boolean,@ColorRes selectedColor:Int= R.color.purple_700) {
    val context = this.context

    if (selected) {
        // Set to filled button style
        this.setBackgroundColor(ContextCompat.getColor(context, selectedColor)) // Solid background color
        this.setTextColor(Color.WHITE) // White text color for filled button
        this.strokeColor = ColorStateList.valueOf(Color.TRANSPARENT) // No border in filled style
    } else {
        // Set to outlined button style
        this.setBackgroundColor(Color.TRANSPARENT) // Transparent background
        this.setTextColor(ContextCompat.getColor(context, R.color.purple_700)) // Text color for outlined button
        this.strokeColor = ContextCompat.getColorStateList(context, R.color.purple_700) // Border color for outlined button
    }
}
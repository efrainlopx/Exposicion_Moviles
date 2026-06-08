package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RoundRectShape
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.exposicion_moviles.R

class ShapeDrawableDemoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private val oval = ShapeDrawable(OvalShape()).apply {
        paint.color = ContextCompat.getColor(context, R.color.palette_primary)
    }

    private val roundedRect = ShapeDrawable(
        RoundRectShape(FloatArray(8) { 32f }, null, null),
    ).apply {
        paint.color = ContextCompat.getColor(context, R.color.palette_secondary)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        oval.setBounds(32, 32, width / 2 - 16, height - 32)
        roundedRect.setBounds(width / 2 + 16, 64, width - 32, height - 64)
        oval.draw(canvas)
        roundedRect.draw(canvas)
    }
}

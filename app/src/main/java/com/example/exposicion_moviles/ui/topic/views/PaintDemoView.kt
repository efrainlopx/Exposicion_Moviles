package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.exposicion_moviles.R

class PaintDemoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_primary)
        style = Paint.Style.FILL
    }

    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_secondary)
        style = Paint.Style.STROKE
        strokeWidth = 14f
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_text_primary)
        textSize = 38f
    }

    private val softPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_accent_soft)
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val widthF = width.toFloat()
        val heightF = height.toFloat()

        canvas.drawCircle(widthF * 0.22f, heightF * 0.35f, 54f, fillPaint)
        canvas.drawCircle(widthF * 0.5f, heightF * 0.35f, 54f, strokePaint)
        canvas.drawRect(widthF * 0.62f, heightF * 0.18f, widthF * 0.9f, heightF * 0.52f, softPaint)
        canvas.drawText("FILL", widthF * 0.12f, heightF * 0.72f, textPaint)
        canvas.drawText("STROKE", widthF * 0.4f, heightF * 0.72f, textPaint)
        canvas.drawText("TEXT", widthF * 0.7f, heightF * 0.72f, textPaint)
    }
}

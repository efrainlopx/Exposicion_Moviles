package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.exposicion_moviles.R

class CanvasDemoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_primary)
        strokeWidth = 10f
    }

    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_secondary)
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_accent)
        style = Paint.Style.FILL
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_text_primary)
        textSize = 42f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val widthF = width.toFloat()
        val heightF = height.toFloat()

        canvas.drawLine(48f, 48f, widthF - 48f, heightF * 0.35f, linePaint)
        canvas.drawRect(48f, heightF * 0.42f, widthF * 0.48f, heightF - 48f, rectPaint)
        canvas.drawCircle(widthF * 0.77f, heightF * 0.66f, 72f, circlePaint)
        canvas.drawText("Canvas", 48f, heightF - 24f, textPaint)
    }
}

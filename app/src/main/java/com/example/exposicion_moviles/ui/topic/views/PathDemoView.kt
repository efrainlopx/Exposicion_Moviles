package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.exposicion_moviles.R

class PathDemoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_primary)
        style = Paint.Style.STROKE
        strokeWidth = 12f
    }

    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_accent_soft)
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val widthF = width.toFloat()
        val heightF = height.toFloat()

        val triangle = Path().apply {
            moveTo(widthF * 0.15f, heightF * 0.75f)
            lineTo(widthF * 0.35f, heightF * 0.2f)
            lineTo(widthF * 0.55f, heightF * 0.75f)
            close()
        }
        canvas.drawPath(triangle, fillPaint)
        canvas.drawPath(triangle, pathPaint)

        val curve = Path().apply {
            moveTo(widthF * 0.6f, heightF * 0.7f)
            quadTo(widthF * 0.72f, heightF * 0.1f, widthF * 0.9f, heightF * 0.65f)
        }
        canvas.drawPath(curve, pathPaint)
    }
}

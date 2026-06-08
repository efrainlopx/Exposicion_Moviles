package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.example.exposicion_moviles.R

class PaintDemoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    enum class Mode {
        FILL,
        STROKE,
        TEXT,
    }

    private data class PaintStamp(
        val mode: Mode,
        val x: Float,
        val y: Float,
        val size: Float,
    )

    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_primary)
        style = Paint.Style.FILL
    }

    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_secondary)
        style = Paint.Style.STROKE
        strokeWidth = 12f
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_accent)
        textAlign = Paint.Align.CENTER
    }

    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_outline)
        strokeWidth = 2f
        alpha = 90
    }

    private val stamps = mutableListOf<PaintStamp>()
    private var currentMode = Mode.FILL
    private var currentSize = 120f

    fun setMode(mode: Mode) {
        currentMode = mode
    }

    fun setDemoSize(size: Float) {
        currentSize = size
    }

    fun clearBoard() {
        stamps.clear()
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawGrid(canvas)
        stamps.forEach { stamp ->
            when (stamp.mode) {
                Mode.FILL -> canvas.drawCircle(stamp.x, stamp.y, stamp.size / 2f, fillPaint)
                Mode.STROKE -> canvas.drawCircle(stamp.x, stamp.y, stamp.size / 2f, strokePaint)
                Mode.TEXT -> {
                    textPaint.textSize = stamp.size * 0.42f
                    canvas.drawText("Paint", stamp.x, stamp.y + (stamp.size * 0.16f), textPaint)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            stamps += PaintStamp(currentMode, event.x, event.y, currentSize)
            invalidate()
            performClick()
            return true
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    private fun drawGrid(canvas: Canvas) {
        val step = 48f
        var x = 0f
        while (x < width) {
            canvas.drawLine(x, 0f, x, height.toFloat(), gridPaint)
            x += step
        }
        var y = 0f
        while (y < height) {
            canvas.drawLine(0f, y, width.toFloat(), y, gridPaint)
            y += step
        }
    }
}

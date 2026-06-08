package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.example.exposicion_moviles.R

class CanvasDemoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    enum class Mode {
        LINE,
        RECTANGLE,
        CIRCLE,
    }

    private data class Stamp(
        val mode: Mode,
        val x: Float,
        val y: Float,
        val size: Float,
    )

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_primary)
        strokeWidth = 10f
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
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

    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_outline)
        strokeWidth = 2f
        alpha = 90
    }

    private val stamps = mutableListOf<Stamp>()
    private var currentMode = Mode.LINE
    private var currentSize = 140f

    fun setMode(mode: Mode) {
        currentMode = mode
    }

    fun setShapeSize(size: Float) {
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
                Mode.LINE -> drawLineStamp(canvas, stamp)
                Mode.RECTANGLE -> drawRectangleStamp(canvas, stamp)
                Mode.CIRCLE -> drawCircleStamp(canvas, stamp)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            stamps += Stamp(currentMode, event.x, event.y, currentSize)
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

    private fun drawLineStamp(canvas: Canvas, stamp: Stamp) {
        val half = stamp.size / 2f
        canvas.drawLine(stamp.x - half, stamp.y - half, stamp.x + half, stamp.y + half, linePaint)
    }

    private fun drawRectangleStamp(canvas: Canvas, stamp: Stamp) {
        val half = stamp.size / 2f
        canvas.drawRect(stamp.x - half, stamp.y - half, stamp.x + half, stamp.y + half, rectPaint)
    }

    private fun drawCircleStamp(canvas: Canvas, stamp: Stamp) {
        canvas.drawCircle(stamp.x, stamp.y, stamp.size / 2f, circlePaint)
    }
}

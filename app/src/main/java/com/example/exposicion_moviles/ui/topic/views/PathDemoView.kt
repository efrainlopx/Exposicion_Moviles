package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.example.exposicion_moviles.R

class PathDemoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    enum class Mode {
        TRIANGLE,
        CURVE,
        WAVE,
    }

    private data class PathStamp(
        val mode: Mode,
        val x: Float,
        val y: Float,
        val size: Float,
    )

    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_primary)
        style = Paint.Style.STROKE
        strokeWidth = 10f
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_accent_soft)
        style = Paint.Style.FILL
    }

    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.palette_outline)
        strokeWidth = 2f
        alpha = 90
    }

    private val stamps = mutableListOf<PathStamp>()
    private var currentMode = Mode.TRIANGLE
    private var currentSize = 140f

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
                Mode.TRIANGLE -> drawTriangle(canvas, stamp)
                Mode.CURVE -> drawCurve(canvas, stamp)
                Mode.WAVE -> drawWave(canvas, stamp)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            stamps += PathStamp(currentMode, event.x, event.y, currentSize)
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

    private fun drawTriangle(canvas: Canvas, stamp: PathStamp) {
        val half = stamp.size / 2f
        val path = Path().apply {
            moveTo(stamp.x, stamp.y - half)
            lineTo(stamp.x - half, stamp.y + half)
            lineTo(stamp.x + half, stamp.y + half)
            close()
        }
        canvas.drawPath(path, fillPaint)
        canvas.drawPath(path, strokePaint)
    }

    private fun drawCurve(canvas: Canvas, stamp: PathStamp) {
        val half = stamp.size / 2f
        val path = Path().apply {
            moveTo(stamp.x - half, stamp.y + half * 0.5f)
            quadTo(stamp.x, stamp.y - half, stamp.x + half, stamp.y + half * 0.5f)
        }
        canvas.drawPath(path, strokePaint)
    }

    private fun drawWave(canvas: Canvas, stamp: PathStamp) {
        val half = stamp.size / 2f
        val path = Path().apply {
            moveTo(stamp.x - half, stamp.y)
            cubicTo(
                stamp.x - half * 0.5f,
                stamp.y - half,
                stamp.x,
                stamp.y + half,
                stamp.x + half * 0.25f,
                stamp.y,
            )
            cubicTo(
                stamp.x + half * 0.5f,
                stamp.y - half,
                stamp.x + half * 0.75f,
                stamp.y + half,
                stamp.x + half,
                stamp.y,
            )
        }
        canvas.drawPath(path, strokePaint)
    }
}

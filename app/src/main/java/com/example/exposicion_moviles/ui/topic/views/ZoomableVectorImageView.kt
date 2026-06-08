package com.example.exposicion_moviles.ui.topic.views

import android.content.Context
import android.graphics.Matrix
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.widget.AppCompatImageView

class ZoomableVectorImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : AppCompatImageView(context, attrs) {

    private val imageMatrixState = Matrix()
    private val scaleDetector = ScaleGestureDetector(context, ScaleListener())
    private var currentScale = 1f
    private var lastX = 0f
    private var lastY = 0f
    private var isDragging = false

    init {
        scaleType = ScaleType.MATRIX
        imageMatrix = imageMatrixState
        isClickable = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleDetector.onTouchEvent(event)

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                lastX = event.x
                lastY = event.y
                isDragging = true
            }

            MotionEvent.ACTION_MOVE -> {
                if (isDragging && !scaleDetector.isInProgress) {
                    val dx = event.x - lastX
                    val dy = event.y - lastY
                    imageMatrixState.postTranslate(dx, dy)
                    imageMatrix = imageMatrixState
                    lastX = event.x
                    lastY = event.y
                }
            }

            MotionEvent.ACTION_UP -> {
                performClick()
                isDragging = false
            }

            MotionEvent.ACTION_CANCEL -> isDragging = false
            MotionEvent.ACTION_POINTER_UP -> {
                lastX = event.x
                lastY = event.y
            }
        }

        return true
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        centerDrawable()
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val nextScale = (currentScale * detector.scaleFactor).coerceIn(MIN_SCALE, MAX_SCALE)
            val factor = nextScale / currentScale
            currentScale = nextScale

            imageMatrixState.postScale(factor, factor, detector.focusX, detector.focusY)
            imageMatrix = imageMatrixState
            return true
        }
    }

    private fun centerDrawable() {
        val drawable = drawable ?: return
        val availableWidth = width - paddingLeft - paddingRight
        val availableHeight = height - paddingTop - paddingBottom
        val dx = paddingLeft + (availableWidth - drawable.intrinsicWidth) / 2f
        val dy = paddingTop + (availableHeight - drawable.intrinsicHeight) / 2f

        currentScale = 1f
        imageMatrixState.reset()
        imageMatrixState.postTranslate(dx, dy)
        imageMatrix = imageMatrixState
    }

    companion object {
        private const val MIN_SCALE = 1f
        private const val MAX_SCALE = 5f
    }
}

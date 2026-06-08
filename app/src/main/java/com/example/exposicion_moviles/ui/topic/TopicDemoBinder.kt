package com.example.exposicion_moviles.ui.topic

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.example.exposicion_moviles.R
import com.example.exposicion_moviles.data.Topic
import com.example.exposicion_moviles.ui.topic.views.CanvasDemoView
import com.example.exposicion_moviles.ui.topic.views.PaintDemoView
import com.example.exposicion_moviles.ui.topic.views.PathDemoView
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

object TopicDemoBinder {

    fun bind(topic: Topic, inflater: LayoutInflater, container: FrameLayout) {
        container.removeAllViews()
        inflater.inflate(topic.demoLayoutRes, container, true)

        when (topic.id) {
            "canvas" -> bindCanvas(container)
            "paint" -> bindPaint(container)
            "path" -> bindPath(container)
            "transition" -> bindTransition(container)
            "animation" -> bindAnimation(container)
        }
    }

    private fun bindCanvas(container: FrameLayout) {
        val board = container.findViewById<CanvasDemoView>(R.id.canvasBoard)
        val sizeLabel = container.findViewById<TextView>(R.id.canvasSizeLabel)
        val sizeSeekBar = container.findViewById<SeekBar>(R.id.canvasSizeSeekBar)
        val clearButton = container.findViewById<MaterialButton>(R.id.canvasClearButton)
        val modeGroup = container.findViewById<MaterialButtonToggleGroup>(R.id.canvasModeGroup)

        board.setShapeSize(sizeSeekBar.progress + 60f)
        sizeLabel.text = "Tamano: ${sizeSeekBar.progress + 60}"

        modeGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (!isChecked) return@addOnButtonCheckedListener
            when (checkedId) {
                R.id.canvasLineButton -> board.setMode(CanvasDemoView.Mode.LINE)
                R.id.canvasRectButton -> board.setMode(CanvasDemoView.Mode.RECTANGLE)
                R.id.canvasCircleButton -> board.setMode(CanvasDemoView.Mode.CIRCLE)
            }
        }

        sizeSeekBar.setOnSeekBarChangeListener(simpleSeekBarListener { value ->
            val size = value + 60
            board.setShapeSize(size.toFloat())
            sizeLabel.text = "Tamano: $size"
        })

        clearButton.setOnClickListener { board.clearBoard() }
    }

    private fun bindPaint(container: FrameLayout) {
        val board = container.findViewById<PaintDemoView>(R.id.paintBoard)
        val sizeLabel = container.findViewById<TextView>(R.id.paintSizeLabel)
        val sizeSeekBar = container.findViewById<SeekBar>(R.id.paintSizeSeekBar)
        val clearButton = container.findViewById<MaterialButton>(R.id.paintClearButton)
        val modeGroup = container.findViewById<MaterialButtonToggleGroup>(R.id.paintModeGroup)

        board.setDemoSize(sizeSeekBar.progress + 60f)
        sizeLabel.text = "Tamano: ${sizeSeekBar.progress + 60}"

        modeGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (!isChecked) return@addOnButtonCheckedListener
            when (checkedId) {
                R.id.paintFillButton -> board.setMode(PaintDemoView.Mode.FILL)
                R.id.paintStrokeButton -> board.setMode(PaintDemoView.Mode.STROKE)
                R.id.paintTextButton -> board.setMode(PaintDemoView.Mode.TEXT)
            }
        }

        sizeSeekBar.setOnSeekBarChangeListener(simpleSeekBarListener { value ->
            val size = value + 60
            board.setDemoSize(size.toFloat())
            sizeLabel.text = "Tamano: $size"
        })

        clearButton.setOnClickListener { board.clearBoard() }
    }

    private fun bindPath(container: FrameLayout) {
        val board = container.findViewById<PathDemoView>(R.id.pathBoard)
        val sizeLabel = container.findViewById<TextView>(R.id.pathSizeLabel)
        val sizeSeekBar = container.findViewById<SeekBar>(R.id.pathSizeSeekBar)
        val clearButton = container.findViewById<MaterialButton>(R.id.pathClearButton)
        val modeGroup = container.findViewById<MaterialButtonToggleGroup>(R.id.pathModeGroup)

        board.setDemoSize(sizeSeekBar.progress + 60f)
        sizeLabel.text = "Tamano: ${sizeSeekBar.progress + 60}"

        modeGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (!isChecked) return@addOnButtonCheckedListener
            when (checkedId) {
                R.id.pathTriangleButton -> board.setMode(PathDemoView.Mode.TRIANGLE)
                R.id.pathCurveButton -> board.setMode(PathDemoView.Mode.CURVE)
                R.id.pathWaveButton -> board.setMode(PathDemoView.Mode.WAVE)
            }
        }

        sizeSeekBar.setOnSeekBarChangeListener(simpleSeekBarListener { value ->
            val size = value + 60
            board.setDemoSize(size.toFloat())
            sizeLabel.text = "Tamano: $size"
        })

        clearButton.setOnClickListener { board.clearBoard() }
    }

    private fun bindTransition(container: FrameLayout) {
        val preview = container.findViewById<ImageView>(R.id.transitionPreview)
        val button = container.findViewById<MaterialButton>(R.id.transitionButton)
        val drawable = preview.background as TransitionDrawable
        var showingSecondState = false

        button.setOnClickListener {
            if (showingSecondState) {
                drawable.reverseTransition(300)
                button.text = container.context.getString(R.string.transition_button_start)
            } else {
                drawable.startTransition(300)
                button.text = container.context.getString(R.string.transition_button_reset)
            }
            showingSecondState = !showingSecondState
        }
    }

    private fun bindAnimation(container: FrameLayout) {
        val preview = container.findViewById<ImageView>(R.id.animationPreview)
        val button = container.findViewById<MaterialButton>(R.id.animationButton)
        var running = false

        fun currentAnimation(): AnimationDrawable = preview.background as AnimationDrawable

        preview.setBackgroundResource(R.drawable.topic_animation)

        button.setOnClickListener {
            if (running) {
                currentAnimation().stop()
                preview.setBackgroundResource(R.drawable.topic_animation)
                button.text = container.context.getString(R.string.animation_button_start)
            } else {
                preview.setBackgroundResource(R.drawable.topic_animation)
                currentAnimation().start()
                button.text = container.context.getString(R.string.animation_button_stop)
            }
            running = !running
        }
    }

    private fun simpleSeekBarListener(onChange: (Int) -> Unit) = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            onChange(progress)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

        override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
    }
}

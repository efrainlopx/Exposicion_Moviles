package com.example.exposicion_moviles.ui.topic

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.exposicion_moviles.R
import com.example.exposicion_moviles.data.Topic
import com.google.android.material.button.MaterialButton

object TopicDemoBinder {

    fun bind(topic: Topic, inflater: LayoutInflater, container: FrameLayout) {
        container.removeAllViews()
        inflater.inflate(topic.demoLayoutRes, container, true)

        when (topic.id) {
            "transition" -> bindTransition(container)
            "animation" -> bindAnimation(container)
        }
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
}

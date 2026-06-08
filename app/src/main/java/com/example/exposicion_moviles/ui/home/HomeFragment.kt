package com.example.exposicion_moviles.ui.home

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exposicion_moviles.R
import com.example.exposicion_moviles.data.Topic
import com.example.exposicion_moviles.data.TopicRepository
import com.example.exposicion_moviles.databinding.FragmentHomeBinding
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderBoard(TopicRepository.all())
    }

    private fun renderBoard(topics: List<Topic>) {
        val margin = resources.getDimensionPixelSize(R.dimen.board_item_margin)
        val buttonPalettes = listOf(
            ButtonPalette(R.color.board_blue, R.color.white),
            ButtonPalette(R.color.board_orange, R.color.white),
            ButtonPalette(R.color.board_red, R.color.white),
            ButtonPalette(R.color.board_violet, R.color.white),
            ButtonPalette(R.color.board_teal, R.color.white),
            ButtonPalette(R.color.board_green, R.color.white),
            ButtonPalette(R.color.board_rose, R.color.white),
            ButtonPalette(R.color.board_cyan, R.color.white),
            ButtonPalette(R.color.board_indigo, R.color.white),
            ButtonPalette(R.color.board_gold, R.color.white),
            ButtonPalette(R.color.board_brown, R.color.white),
            ButtonPalette(R.color.board_slate, R.color.white),
            ButtonPalette(R.color.board_lime, R.color.white),
        )

        topics.forEachIndexed { index, topic ->
            val palette = buttonPalettes[index % buttonPalettes.size]
            val button = MaterialButton(
                requireContext(),
                null,
                com.google.android.material.R.attr.materialButtonStyle,
            ).apply {
                text = "${topic.number}. ${topic.buttonLabel}"
                isAllCaps = false
                gravity = Gravity.CENTER
                insetTop = 0
                insetBottom = 0
                strokeWidth = 0
                minimumHeight = resources.getDimensionPixelSize(R.dimen.board_button_min_height)
                val padding = resources.getDimensionPixelSize(R.dimen.board_button_padding)
                setPaddingRelative(padding, padding, padding, padding)
                backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(context, palette.backgroundRes),
                )
                setTextColor(ContextCompat.getColor(context, palette.textRes))
                setOnClickListener {
                    findNavController().navigate(
                        R.id.action_homeFragment_to_topicDetailFragment,
                        bundleOf(TopicRepository.ARG_TOPIC_ID to topic.id),
                    )
                }
            }

            val params = GridLayout.LayoutParams().apply {
                width = 0
                height = ViewGroup.LayoutParams.WRAP_CONTENT
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                rowSpec = GridLayout.spec(GridLayout.UNDEFINED)
                setMargins(margin)
            }
            binding.boardGrid.addView(button, params)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private data class ButtonPalette(
        val backgroundRes: Int,
        val textRes: Int,
    )
}

package com.example.exposicion_moviles.ui.topic

import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.exposicion_moviles.R
import com.example.exposicion_moviles.data.Topic
import com.example.exposicion_moviles.data.TopicRepository
import com.example.exposicion_moviles.databinding.FragmentTopicDetailBinding
import com.google.android.material.textview.MaterialTextView

class TopicDetailFragment : Fragment() {

    private var _binding: FragmentTopicDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTopicDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topicId = arguments?.getString(TopicRepository.ARG_TOPIC_ID)
        val topic = topicId?.let(TopicRepository::findById)

        if (topic == null) {
            showMissingTopic()
            return
        }

        bindTopic(topic)
    }

    private fun bindTopic(topic: Topic) {
        requireActivity().title = topic.title
        binding.topicIndex.text = getString(R.string.topic_number_format, topic.number)
        binding.topicTitle.text = topic.title
        binding.topicSummary.text = topic.summary

        renderList(binding.keyPointsContainer, topic.keyPoints, false)
        renderList(binding.logicFilesContainer, topic.logicFiles, true)
        renderList(binding.xmlFilesContainer, topic.xmlFiles, true)

        TopicDemoBinder.bind(topic, layoutInflater, binding.demoContainer)
    }

    private fun showMissingTopic() {
        requireActivity().title = getString(R.string.topic_not_found)
        binding.topicIndex.text = getString(R.string.topic_not_found)
        binding.topicTitle.text = getString(R.string.topic_not_found)
        binding.topicSummary.text = getString(R.string.topic_not_found_message)
    }

    private fun renderList(container: ViewGroup, items: List<String>, monospace: Boolean) {
        container.removeAllViews()
        items.forEach { item ->
            container.addView(
                MaterialTextView(requireContext()).apply {
                    text = if (monospace) item else "• $item"
                    setTextColor(ContextCompat.getColor(context, R.color.palette_text_primary))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                    if (monospace) {
                        typeface = Typeface.MONOSPACE
                        setPadding(0, 0, 0, 12)
                    } else {
                        setPadding(0, 0, 0, 16)
                    }
                },
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

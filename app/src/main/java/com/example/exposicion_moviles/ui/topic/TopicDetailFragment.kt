package com.example.exposicion_moviles.ui.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exposicion_moviles.R
import com.example.exposicion_moviles.data.Topic
import com.example.exposicion_moviles.data.TopicRepository
import com.example.exposicion_moviles.databinding.FragmentTopicDetailBinding

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
        TopicDemoBinder.bind(topic, layoutInflater, binding.demoContainer)
    }

    private fun showMissingTopic() {
        requireActivity().title = getString(R.string.topic_not_found)
        binding.topicIndex.text = getString(R.string.topic_not_found)
        binding.topicTitle.text = getString(R.string.topic_not_found)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

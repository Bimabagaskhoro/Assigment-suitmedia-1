package com.bimabagaskhoro.assigment1.ui.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.assigment1.R
import com.bimabagaskhoro.assigment1.databinding.FragmentEventBinding
import com.bimabagaskhoro.assigment1.ui.adapter.EventAdapter

class EventFragment : Fragment() {
    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val eventAdapter = EventAdapter()
            val viewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[EventViewModel::class.java]
            val movie = viewModel.getMovie()
            eventAdapter.setData(movie)
            binding.apply {
                rvEvent.layoutManager = LinearLayoutManager(context)
                rvEvent.setHasFixedSize(true)
                rvEvent.adapter = eventAdapter
                imgBack.setOnClickListener {
                    it.findNavController().navigate(R.id.action_eventFragment_to_chooseFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
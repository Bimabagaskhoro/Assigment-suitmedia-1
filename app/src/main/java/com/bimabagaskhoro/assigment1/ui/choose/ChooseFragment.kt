package com.bimabagaskhoro.assigment1.ui.choose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bimabagaskhoro.assigment1.R
import com.bimabagaskhoro.assigment1.databinding.FragmentChooseBinding
import com.bimabagaskhoro.assigment1.domain.model.ItemEvent
import com.bimabagaskhoro.assigment1.domain.model.ItemGuest
import com.bimabagaskhoro.assigment1.sf.AppSharedPreferencesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseFragment : Fragment() {
    companion object {
        const val EXTRA_DATA_EVENT = "extra_data_event"
    }

    private var _binding: FragmentChooseBinding? = null
    private val  binding get() = _binding!!
    private val viewModel: AppSharedPreferencesViewModel by viewModels()
    private lateinit var itemEvent: ItemEvent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChooseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            itemEvent = arguments?.getParcelable(EXTRA_DATA_EVENT)!!
            binding.tvChooseEvent.text = itemEvent.name
        }

        binding.apply {
            tvName.text = viewModel.getUser().toString()
            tvChooseEvent.setOnClickListener {
                findNavController().navigate(R.id.action_chooseFragment_to_eventFragment)
            }
            tvChooseGuest.setOnClickListener {
                findNavController().navigate(R.id.action_chooseFragment_to_guestFragment)
            }
            imgLogout.setOnClickListener {
                viewModel.logoutUser()
                findNavController().navigate(R.id.action_chooseFragment_to_mainFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
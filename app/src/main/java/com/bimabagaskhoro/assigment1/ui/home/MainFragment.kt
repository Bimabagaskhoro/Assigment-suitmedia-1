package com.bimabagaskhoro.assigment1.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bimabagaskhoro.assigment1.R
import com.bimabagaskhoro.assigment1.databinding.FragmentMainBinding
import com.bimabagaskhoro.assigment1.sf.AppSharedPreferencesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppSharedPreferencesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.checkInstance()
        if (viewModel.isUserLogin()) {
            findNavController().navigate(R.id.action_mainFragment_to_chooseFragment)
        } else {
            binding.apply {
                btnNext.setOnClickListener {
                    val email = edtName.text.toString()
                    if (email.isNullOrEmpty()) {
                        edtName.error = "Please field your name"
                        edtName.requestFocus()
                    } else {
                        viewModel.loginUser(edtName.text.toString())
                        findNavController().navigate(R.id.action_mainFragment_to_chooseFragment)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
package com.example.parcial01pdm.ui.informationpintura


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcial01pdm.databinding.FragmentInfoPinturaBinding
import com.example.parcial01pdm.ui.viewmodel.PinturaViewModel

class InfoPintura : Fragment() {

    private val pinturaViewModel: PinturaViewModel by activityViewModels {
        PinturaViewModel.Factory
    }

    private lateinit var binding: FragmentInfoPinturaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoPinturaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = pinturaViewModel
    }

}
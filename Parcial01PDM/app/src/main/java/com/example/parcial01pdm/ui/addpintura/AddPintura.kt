package com.example.parcial01pdm.ui.addpintura

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial01pdm.databinding.FragmentAddMuseumBinding
import com.example.parcial01pdm.ui.viewmodel.PinturaViewModel

class AddPintura : Fragment() {

    private val pinturaViewModel: PinturaViewModel by activityViewModels {
        PinturaViewModel.Factory
    }

    private lateinit var binding: FragmentAddPinturaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPinturaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = PinturaViewModelinturaViewModel
    }

    private fun observeStatus() {
        PinturaViewModel.status.observe(viewLifecycleOwner) {status ->
            when {
                status.equals(PinturaViewModel.SOMETHING_WRONG) -> {
                    Log.d("Error", status)
                    PinturaViewModel.clearStatus()
                }
                status.equals(PinturaViewModel.PINTURA_CREATED) -> {
                    Log.d("realizo", status)
                    Log.d("realizo esto: ", PinturaViewModel.getPinturas().toString())

                    PinturaViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}
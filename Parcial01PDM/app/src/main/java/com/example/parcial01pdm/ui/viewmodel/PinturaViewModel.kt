package com.example.parcial01pdm.ui.viewmodel.addpintura


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial01pdm.databinding.FragmentAddPinturaBinding
import com.example.parcial01pdm.ui.viewmodel.PinturaViewModel

class AddMuseum : Fragment() {

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
        binding.viewmodel = pinturaViewModel
    }

    private fun observeStatus() {
        pinturaViewModel.status.observe(viewLifecycleOwner) {status ->
            when {
                status.equals(PinturaViewModel.SOMETHING_WRONG) -> {
                    Log.d("peto papito", status)
                    pinturaViewModel.clearStatus()
                }
                status.equals(PinturaViewModel.MUSEUM_CREATED) -> {
                    Log.d("se creo papito", status)
                    Log.d("te creo esto: ", pinturaViewModel.getMuseums().toString())

                    pinturaViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}
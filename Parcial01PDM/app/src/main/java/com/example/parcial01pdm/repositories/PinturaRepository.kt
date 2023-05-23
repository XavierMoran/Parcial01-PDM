package com.example.parcial01pdm.repositories

import com.example.parcial01pdm.data.model.PinturaModel
import com.example.parcial01pdm.ui.addpintura.AddPintura

class PinturaRepository (private val pinturas: MutableList<PinturaModel>){
    fun getPinturas() = pinturas
    fun addPintura(pintura: PinturaModel) = pinturas.add(pintura)
}
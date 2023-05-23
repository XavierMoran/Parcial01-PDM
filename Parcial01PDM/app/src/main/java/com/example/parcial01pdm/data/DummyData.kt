package com.example.parcial01pdm.data

import com.example.parcial01pdm.data.model.PinturaModel

val name = "La noche estrellada"
val autor = "Vicent van Gogh"

val name2 = "La ultima cena"
val autor2 = "Leonardo da Vinci"

val museums = mutableListOf(
    PinturaModel(name, autor),
    PinturaModel(name2, autor2)
)
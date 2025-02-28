package com.example.territorios

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// Clase que representa un Territorio con una lista de ubicaciones
data class Territory(val id: Int, val locations: List<String>)

// ViewModel que almacena la lista de territorios
class TerritoryViewModel : ViewModel() {
    private val _territories = MutableStateFlow(
        listOf(
            Territory(1, listOf("Ubicación A", "Ubicación B", "Ubicación C")),
            Territory(2, listOf("Ubicación D", "Ubicación E", "Ubicación F")),
            Territory(3, listOf("Ubicación G", "Ubicación H", "Ubicación I"))
        )
    )
    val territories = _territories.asStateFlow()
}

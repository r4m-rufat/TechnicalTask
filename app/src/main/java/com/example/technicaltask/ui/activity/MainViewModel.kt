package com.example.technicaltask.ui.activity

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltask.constants.Constants
import com.example.technicaltask.model.Country
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val constants = Constants()
    private val _countries = MutableStateFlow(constants.countries)
    val countries: StateFlow<List<Country>> = _countries

    private val _selectedCountries = MutableStateFlow<List<Country>>(emptyList())
    val selectedCountries: StateFlow<List<Country>> = _selectedCountries

    private var job: Job? = null

    // Function to trigger the movie search when the button is clicked
    fun toggleCountrySelection(country: Country, isSelected: Boolean) {
        job?.cancel()

        viewModelScope.launch {
            val currentSelected = _selectedCountries.value.toMutableList()
            if (isSelected) {
                currentSelected.add(country)
            } else {
                currentSelected.remove(country)
            }
            _selectedCountries.value = currentSelected.toList()
        }
    }

}
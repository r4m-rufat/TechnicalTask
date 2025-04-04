package com.example.technicaltask.ui.activity.country

import android.R.attr.title
import android.R.id.title
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.technicaltask.constants.Constants
import com.example.technicaltask.model.Country
import com.example.technicaltask.ui.activity.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryScreen(
//    navHostController: NavHostController,
    viewModel: MainViewModel
) {
//    val countries = Constants()
    val isStarred = rememberSaveable { mutableStateOf(false) }

    val countryList by viewModel.countries.collectAsState()
    val selectedCountries by viewModel.selectedCountries.collectAsState()
    var savedCountries = remember { mutableStateListOf<Country>() } // Use rememberSaveable
    LaunchedEffect(viewModel.selectedCountries) {
        viewModel.selectedCountries.collect { newCheckedItems ->
            savedCountries.clear()
            savedCountries.addAll(newCheckedItems)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Ölkələr",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal
                            ) // Customize text style
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { isStarred.value = !isStarred.value }) {
                        Icon(
                            imageVector = if (isStarred.value) Icons.Filled.Star else Icons.Outlined.StarOutline,
                            contentDescription = "Star",
//                            tint = if(isStarred.value) Color.Yellow else Color.Unspecified
                        )
                    }
                },
            )

        }
    ) { innerPadding ->

        Column {
            Text(text = "")
            LazyColumn {

            }
        }

        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                Text(
                    "Ölkələri seçin",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Normal
                    ) // Customize text style
                )

            }

            items(countryList) { country ->
                CountryScreenItem(
                    countryName = country.name, isChecked =
                        selectedCountries.contains(country),
                    onCheckedChange = { isChecked ->
                        viewModel.toggleCountrySelection(country, isChecked)
                    }
                )
            }

            println(savedCountries.size)
        }
    }

}
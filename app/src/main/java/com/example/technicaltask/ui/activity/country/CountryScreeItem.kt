package com.example.technicaltask.ui.activity.country

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CountryScreenItem(
    countryName: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit,
//                      navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
            .clickable {
//            navController.navigate("favorites")
            },
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                modifier = Modifier
                    .size(40.dp) // Adjust size of the entire checkbox
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    ),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = MaterialTheme.colorScheme.onBackground,
                    checkmarkColor = Color.Green
                )

            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = countryName,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


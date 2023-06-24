package com.uv72dev.littlelemon

import android.content.SharedPreferences
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController, sharedPreferences: SharedPreferences){
    //temporary button
    Button(
        onClick = {
            navController.navigate(Profile.route)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF4CE14)),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "profile", style = MaterialTheme.typography.h1, fontWeight = FontWeight.Medium)
    }
}
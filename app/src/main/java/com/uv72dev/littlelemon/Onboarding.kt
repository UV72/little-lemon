package com.uv72dev.littlelemon

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uv72dev.littlelemon.ui.theme.LittleLemonTheme

val fonts = FontFamily(
    Font(R.font.karla_regular),
    Font(R.font.markazi_text_regular)
)


@Composable
fun Onboarding(navController: NavController, sharedPreferences: SharedPreferences){

    Column(
    ){
        var firstName = remember {
            mutableStateOf("")
        }
        var lastName = remember {
            mutableStateOf("")
        }
        var email = remember {
            mutableStateOf("")
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon logo",
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(.1f)
        )
        Text(
            text = "Let's get to know you",
            Modifier
                .background(color = Color(0xFF495E57))
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .padding(horizontal = 8.dp, vertical = 22.dp),
            style = MaterialTheme.typography.h1,
            fontSize = 24.sp,
            color = Color(0xFFEDEFEE),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Personal information",
            fontSize = 20.sp,
            style = MaterialTheme.typography.h1,
            color = Color(0xFF333333),
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 20.dp)
        )

        Column(
            Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = firstName.value,
                onValueChange = {newText: String -> firstName.value=newText},
                label = {
                    Text(text = "First name", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                },
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            )
            OutlinedTextField(
                value = lastName.value,
                onValueChange = {newText: String -> lastName.value=newText},
                label = {
                    Text(text = "Last name", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                },
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            )
            OutlinedTextField(
                value = email.value,
                onValueChange = {newText: String -> email.value=newText},
                label = {
                    Text(text = "e-Mail", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                },
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            )

        }

        Button(
            onClick = {
                      if(firstName.value.isBlank()||lastName.value.isBlank()||email.value.isBlank()){

                      }else{
                          sharedPreferences.edit()
                              .putString("firstName", firstName.value)
                              .putString("lastName", lastName.value)
                              .putString("email", email.value)
                              .putBoolean("loggedIn", true)
                              .commit()
                          navController.navigate(Home.route)
                      }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF4CE14)),
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Register", style = MaterialTheme.typography.h1, fontWeight = FontWeight.Medium)
        }

        if(firstName.value.isBlank()||lastName.value.isBlank()||email.value.isBlank()){
            Text(
                text = "Please fill all the details!",
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Light,
                color = Color.Red,
                modifier = Modifier.padding(10.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview(){
    LittleLemonTheme {
        //Onboarding()
    }
}
package com.uv72dev.littlelemon

import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import com.uv72dev.littlelemon.ui.theme.*

class MainActivity : ComponentActivity() {


//    private val sharedPreferences by lazy {
//        getSharedPreferences("LittleLemon", MODE_PRIVATE)
//    }
//
//    private val loggedIn = MutableLiveData<Boolean>()
//
//    private val prefListener = OnSharedPreferenceChangeListener{sharedPreferences, s ->
//        loggedIn.value = sharedPreferences.getBoolean(s, true)
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var firstScreen: Destinations = Onboarding
//        if(loggedIn){
//            firstScreen = Home
//        }
        val sharedPreferences = getSharedPreferences("LittleLemon", MODE_PRIVATE)
        setContent {
            LittleLemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    var startLocation: Destinations = Onboarding
                    if(sharedPreferences.getBoolean("loggedIn", false)){
                        startLocation = Home
                    }
                    NavigationComposable(startLocation, sharedPreferences)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LittleLemonTheme {
        Greeting("Android")
    }
}
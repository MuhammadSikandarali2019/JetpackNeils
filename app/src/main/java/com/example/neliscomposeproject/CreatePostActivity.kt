package com.example.neliscomposeproject

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.neliscomposeproject.activities.ui.theme.NelisComposeProjectTheme
import com.example.neliscomposeproject.uicomponents.MyTopAppBar

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NelisComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                   color =  colorResource(id = R.color.followBtnColor),
                    color = MaterialTheme.colors.background
                ) {

                    MainContent(this)

//                    Greeting2("Android")
                }
            }
        }
    }
}


@Composable
private fun MainContent(context: Activity) {
    Scaffold(
//        modifier = Modifier.background(colorResource(id = R.color.followBtnColor)),
        topBar = {
            MyTopAppBar(context, "Create Post")
        },

        ) { padding ->
        Modifier.padding(padding)
    }
}


@Preview
@Composable
private fun PreviewMainContent() {
    MainContent(ProfileActivity())
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    NelisComposeProjectTheme {
        Greeting2("Android")
    }
}
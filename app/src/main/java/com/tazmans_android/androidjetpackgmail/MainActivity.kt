package com.tazmans_android.androidjetpackgmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tazmans_android.androidjetpackgmail.components.GmailDrawerMenu
import com.tazmans_android.androidjetpackgmail.components.HomeAppBar
import com.tazmans_android.androidjetpackgmail.ui.theme.AndroidJetpackGmailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackGmailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope) },
        drawerContent = {
            GmailDrawerMenu(scrollState)
        }
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidJetpackGmailTheme {
        GmailApp()
    }
}
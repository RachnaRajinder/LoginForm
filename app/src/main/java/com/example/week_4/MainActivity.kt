package com.example.week_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week_4.ui.theme.Week_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        NewUI()
                    }
                }
            }
        }
    }
}

@Composable
private fun NewUI(){
    Column {
        Text(text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
             )
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        val showPassword by remember {
            mutableStateOf(false)
        }
        TextField(value = email, onValueChange = {newText -> email = newText},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon" )
            },
            label = {Text (text = "Email")},
            modifier = Modifier.fillMaxWidth(0.9f)
            )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = password, onValueChange = {newText -> password = newText},
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Lock Icon" )
            },
            label = {Text (text = "Password")},
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {},
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            Text(text = "Submit")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week_4Theme {
        NewUI()
    }
}
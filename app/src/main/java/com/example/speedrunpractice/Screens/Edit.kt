package com.example.speedrunpractice.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun editScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Edit", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("New Task") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Text") },
                visualTransformation = PasswordVisualTransformation(),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (password == confirmPassword) {

                } else {
                    errorMessage = "Passwords do not match"
                }
            }) {
                Text("Add Task")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                if (password == confirmPassword) {

                } else {
                    errorMessage = "Passwords do not match"
                }
            }) {
                Text("Favorite")
            }
            Text(errorMessage, color = Color.Red)
        }
    }
    Row (modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom){
        Button(
            onClick = {

            },
            modifier = Modifier
                .size(100.dp) // Задайте желаемый размер здесь
                .padding(bottom = 16.dp) // Добавляем отступ от нижнего края) // Выравнивание по горизонтали
        ) {
            Text("All tasks")
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .size(100.dp) // Задайте желаемый размер здесь
                .padding(bottom = 16.dp) // Добавляем отступ от нижнего края) // Выравнивание по горизонтали
        ) {
            Text("Completed")
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .size(100.dp) // Задайте желаемый размер здесь
                .padding(bottom = 16.dp) // Добавляем отступ от нижнего края) // Выравнивание по горизонтали
        ) {
            Text("Favirites")
        }
        Button(
            onClick = {

            },
            modifier = Modifier
                .size(100.dp) // Задайте желаемый размер здесь
                .padding(bottom = 16.dp) // Добавляем отступ от нижнего края) // Выравнивание по горизонтали
        ) {
            Text("Profile")
        }
    }
}

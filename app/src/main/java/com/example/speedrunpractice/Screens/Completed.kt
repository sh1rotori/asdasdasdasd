package com.example.speedrunpractice.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun completedScreen() {
    // Список задач, начальные тестовые задачи
    val tasks = remember {
        mutableStateListOf(
            Pair("Task 1", "Description 1"),
            Pair("Task 2", "Description 2"),
            Pair("Task 3", "Description 3")
        )
    }
    // Флаг для отображения экрана создания задачи
    var creatingTask by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Completed", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Отображение списка задач
        Column {
            tasks.forEachIndexed { index, task ->
                var editingTask by remember { mutableStateOf(false) }
                var editedTaskName by remember { mutableStateOf(task.first) }
                var editedTaskDescription by remember { mutableStateOf(task.second) }

                if (editingTask) {
                    Column {
                        TextField(
                            value = editedTaskName,
                            onValueChange = { editedTaskName = it },
                            label = { Text("Edit Task Name") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = editedTaskDescription,
                            onValueChange = { editedTaskDescription = it },
                            label = { Text("Edit Task Description") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            Button(onClick = {
                                tasks[index] = Pair(editedTaskName, editedTaskDescription)
                                editingTask = false
                            }) {
                                Text("Save")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { editingTask = false }) {
                                Text("Cancel")
                            }
                        }
                    }
                } else {
                    Row {
                        Column {
                            Text(text = task.first, fontSize = 30.sp)
                            Text(text = task.second, fontSize = 15.sp)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Row() {
                        Button(onClick = {
                            tasks.removeAt(index)
                        },)
                        {
                            Text("Delete")
                        }

                        Button(onClick = {
                            tasks.removeAt(index)
                        }) {
                            Text("Umcomplete")
                        }

                        Button(onClick = {
                            editingTask = true
                        }) {
                            Text("Edit")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка для отображения экрана создания задачи
        Button(onClick = { creatingTask = true }) {
            Text("New Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

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

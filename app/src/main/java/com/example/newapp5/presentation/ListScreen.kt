package com.example.newapp5.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.newapp5.domain.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(onItemClick: () -> Unit, viewModel: NotesViewModel = hiltViewModel()) {

    val uiState = viewModel.resultState.collectAsState().value
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.getNotesList()
    }

    //No items - state
    // items - state
    //loading - state


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("BrightNotes")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color.White,
                    containerColor = Color.Blue
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(imageVector = Icons.Default.Add, "") //accessibility
            }
        }
    )
    { paddingValues ->

        LazyColumn(Modifier.padding(paddingValues)) {
            items(uiState.items) { item ->
                NoteRow(
                    item,
                    onItemClick = onItemClick,
                    onDelete = {
                        viewModel.deleteNote(item)
                    })
            }
        }

    }

    if (showDialog) {
        AlertDialog(
            title = {
                Text(
                    text = "New note",
                    color = Color.Blue,
                    style = MaterialTheme.typography.titleLarge
                )
            },
            text = {
                Column() {
                    OutlinedTextField(
                        value = uiState.title,
                        onValueChange = {
                            viewModel.onTitleChange(it)
                        },
                        modifier = Modifier.padding(top = 10.dp),
                        label = { Text("title") },
                    )
                    OutlinedTextField(
                        value = uiState.description,
                        onValueChange = {
                            viewModel.onDescriptionChange(it)
                        },
                        modifier = Modifier.padding(top = 10.dp),
                        label = { Text("description") },
                    )
                }
            },
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.insertNote()
                        showDialog = false
                    }
                ) {
                    Text("Save")
                }
            }
        )
    }
}

@Composable
fun NoteRow(item: Note, onItemClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Cyan
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable {
                    onItemClick()
                }, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(12.dp))
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
            }

            IconButton(onClick = { onDelete() }) {
                Icon(imageVector = Icons.Default.Delete, "Delete item")
            }
        }
    }
}
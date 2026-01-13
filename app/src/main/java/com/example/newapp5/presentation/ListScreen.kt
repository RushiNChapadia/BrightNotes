package com.example.newapp5.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newapp5.domain.Note

@Composable
fun ListScreen () {
    val vm : ListViewModel = viewModel()
    val lis = listOf(Note("Note1"))
}
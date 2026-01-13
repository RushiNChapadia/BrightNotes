package com.example.newapp5.presentation

import com.example.newapp5.domain.Note

data class UiState(
    val items: List<Note> = listOf(Note("First item"), Note("SecondItem")),
    val isLoading: Boolean = false
)

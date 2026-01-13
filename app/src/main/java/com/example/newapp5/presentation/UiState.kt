package com.example.newapp5.presentation

import com.example.newapp5.domain.Note

data class UiState(
    val loading: Boolean = false,
    val items: List<Note> = emptyList(),
    val errorMessage: String = "",
    val title: String = "",
    val description: String = ""
)

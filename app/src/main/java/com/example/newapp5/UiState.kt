package com.example.newapp5

import com.example.newapp5.domain.Note

data class UiState(
    val loading: Boolean = false,
    val notesList: List<Note> = emptyList(),
    val errorMessage: String = ""
)

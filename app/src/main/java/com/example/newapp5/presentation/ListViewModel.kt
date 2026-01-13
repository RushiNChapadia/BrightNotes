package com.example.newapp5.presentation

import androidx.lifecycle.ViewModel
import com.example.newapp5.domain.usecase.GetNotesUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListViewModel (
    getNotesUseCase : GetNotesUsecase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState())
    val uiState = _uiState.asStateFlow()

    fun loadItems() {
//        getNotesUseCase.
    }


}
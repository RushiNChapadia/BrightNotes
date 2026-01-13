package com.example.newapp5.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp5.domain.usecase.GetNotesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor (
     private val getNotesUseCase : GetNotesUsecase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState())
    val uiState = _uiState.asStateFlow()

    fun loadItems() {
        fun loadItems() {
            viewModelScope.launch {
                getNotesUseCase().collectLatest { notesEntities ->
//                    _uiState.value.items = notesEntities

               }
            }
        }
    }


}
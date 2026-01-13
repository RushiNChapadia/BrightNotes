package com.example.newapp5.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp5.UiState
import com.example.newapp5.domain.Note
import com.example.newapp5.domain.usecase.DeleteNotesUsecase
import com.example.newapp5.domain.usecase.GetNotesUsecase
import com.example.newapp5.domain.usecase.InsertNotesUsecase
import com.example.newapp5.domain.usecase.UpdateNotesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesUsecase: GetNotesUsecase,
    private val insertNotesUsecase: InsertNotesUsecase,
    private val updateNotesUsecase: UpdateNotesUsecase,
    private val deleteNotesUsecase: DeleteNotesUsecase
) : ViewModel() {

    private val _resultState = MutableStateFlow<UiState>(UiState())
    val resultState = _resultState.asStateFlow()

    fun getNotesList() {
        viewModelScope.launch {
            try {
                _resultState.value = _resultState.value.copy(loading = true)
                getNotesUsecase.invoke().collect { notesEntities ->
                    _resultState.value =
                        _resultState.value.copy(loading = false, notesList = notesEntities)
                }
            } catch (e: Exception) {
                _resultState.value = _resultState.value.copy(
                    loading = false,
                    notesList = emptyList(),
                    errorMessage = e.message ?: "Unknown Exception Found"
                )
            }
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            insertNotesUsecase.invoke(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            updateNotesUsecase.invoke(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNotesUsecase.invoke(note)
        }
    }
}
package com.example.newapp5.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp5.domain.Note
import com.example.newapp5.domain.usecase.DeleteNotesUsecase
import com.example.newapp5.domain.usecase.GetNotesUsecase
import com.example.newapp5.domain.usecase.InsertNotesUsecase
import com.example.newapp5.domain.usecase.UpdateNotesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    fun onTitleChange(title: String) {
        _resultState.value = _resultState.value.copy(title = title)
    }

    fun onDescriptionChange(description: String) {
        _resultState.value = _resultState.value.copy(description = description)
    }


    fun getNotesList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _resultState.value = _resultState.value.copy(loading = true)

                getNotesUsecase.invoke().collect { notesEntities ->
                    _resultState.value =
                        _resultState.value.copy(loading = false, items = notesEntities)
                }
            } catch (e: Exception) {
                _resultState.value = _resultState.value.copy(
                    loading = false,
                    items = emptyList(),
                    errorMessage = e.message ?: "Unknown Exception Found"
                )
            }
        }
    }

    fun insertNote() {
        if (_resultState.value.title.isNotEmpty() && _resultState.value.description.isNotEmpty()) {
            val note = Note(
                title = _resultState.value.title,
                description = _resultState.value.description
            )
            viewModelScope.launch(Dispatchers.IO) {
                insertNotesUsecase.invoke(note)
                onTitleChange("")
                onDescriptionChange("")
            }
        }
    }


    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            updateNotesUsecase.invoke(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNotesUsecase.invoke(note)
        }
    }
}
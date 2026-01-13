package com.example.newapp5.domain.usecase

import com.example.newapp5.domain.repository.NotesRepository
import javax.inject.Inject

class DeleteNotesUsecase @Inject constructor(val notesRepository: NotesRepository) {
    suspend fun invoke(){

    }
}
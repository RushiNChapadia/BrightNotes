package com.example.newapp5.domain.usecase

import com.example.newapp5.domain.Note
import com.example.newapp5.domain.repository.NotesRepository
import javax.inject.Inject

class UpdateNotesUsecase @Inject constructor(private val notesRepository: NotesRepository) {
    suspend operator fun invoke(note: Note) {
        notesRepository.updateNotesInLocal(note)
    }
}
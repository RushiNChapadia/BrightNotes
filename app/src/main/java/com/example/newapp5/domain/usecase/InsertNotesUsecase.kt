package com.example.newapp5.domain.usecase

import com.example.newapp5.domain.Note
import com.example.newapp5.domain.repository.NotesRepository
import javax.inject.Inject

class InsertNotesUsecase @Inject constructor(private val notesRepository: NotesRepository) {

    suspend operator fun invoke(note: Note) {
        notesRepository.insertNotesToLocal(note)
    }
}
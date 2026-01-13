package com.example.newapp5.domain.usecase

import com.example.newapp5.data.local.NotesEntity
import com.example.newapp5.domain.Note
import com.example.newapp5.domain.repository.NotesRepository
import javax.inject.Inject

class DeleteNotesUsecase @Inject constructor(private val notesRepository: NotesRepository) {
    suspend operator fun invoke(noteEntity: Note){
        notesRepository.deleteInLocal(noteEntity)
    }
}
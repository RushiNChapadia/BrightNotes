package com.example.newapp5.domain.usecase

import com.example.newapp5.data.local.NotesEntity
import com.example.newapp5.domain.Note
import com.example.newapp5.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUsecase @Inject constructor(private val notesRepository: NotesRepository){
    operator fun invoke(): Flow<List<Note>> {
        return notesRepository.getNotesFromLocal()
    }
}
package com.example.newapp5.domain.usecase

import com.example.newapp5.data.NotesEntity
import com.example.newapp5.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUsecase @Inject constructor(val notesRepository: NotesRepository){
    suspend fun invoke(): Flow<List<NotesEntity>> {
        return notesRepository.getNotesFromLocal()
    }
}
package com.example.newapp5.domain.repository

import com.example.newapp5.data.local.NotesDao
import com.example.newapp5.data.local.NotesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesRepository @Inject constructor(val notesDao: NotesDao) {

    suspend fun insertNotesToLocal(notesEntity: NotesEntity){
        notesDao.addNotes(notesEntity)
    }

    suspend fun getNotesFromLocal(): Flow<List<NotesEntity>> {
        return notesDao.getAllNotes()
    }

    suspend fun deleteInLocal(notesEntity: NotesEntity){
        notesDao.deleteNotes(notesEntity)
    }

    suspend fun updateNotesInLocal(notesEntity: NotesEntity){
        notesDao.updateNotes(notesEntity)
     }
}
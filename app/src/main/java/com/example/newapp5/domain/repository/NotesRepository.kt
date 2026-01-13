package com.example.newapp5.domain.repository

import com.example.newapp5.data.local.NotesDao
import com.example.newapp5.data.toDomain
import com.example.newapp5.data.toEntity
import com.example.newapp5.domain.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NotesRepository @Inject constructor(private val notesDao: NotesDao) {

    suspend fun insertNotesToLocal(notesEntity: Note) {
        notesDao.addNotes(
            notesEntity.toEntity()
        )
    }

    fun getNotesFromLocal(): Flow<List<Note>> {

        return notesDao.getAllNotes().map { list ->
            list.map {
                it.toDomain()
            }
        }
    }

    suspend fun deleteInLocal(noteEntity: Note) {
        notesDao.deleteNotes(
            noteEntity.toEntity()
        )
    }

    suspend fun updateNotesInLocal(noteEntity: Note) {
        notesDao.updateNotes(
            noteEntity.toEntity()
        )
    }
}
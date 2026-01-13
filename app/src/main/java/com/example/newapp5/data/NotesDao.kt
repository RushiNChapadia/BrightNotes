package com.example.newapp5.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNotes(notesEntity: NotesEntity)

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getAllNotes(): Flow<List<NotesEntity>>

    @Update
    suspend fun updateNotes(notesEntity: NotesEntity)

    @Delete
    suspend fun deleteNotes(notesEntity: NotesEntity)

}
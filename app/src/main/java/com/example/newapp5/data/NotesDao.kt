package com.example.newapp5.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNotes(notesEntity: NotesEntity)

    @Query("SELECT * FROM notes ORDER BY id ASC")
    suspend fun getAllNotes(): List<NotesEntity>
}
package com.example.newapp5.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDb: RoomDatabase() {
    abstract fun notesDao(): NotesDao
}
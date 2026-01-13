package com.example.newapp5.data

import androidx.room.Database

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDb {
    abstract fun notesDao(): NotesDao
}
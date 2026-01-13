package com.example.newapp5.data.di

import android.content.Context
import androidx.room.Room
import com.example.newapp5.data.local.NotesDao
import com.example.newapp5.data.local.NotesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): NotesDb {
        return Room.databaseBuilder(
            context.applicationContext,
            NotesDb::class.java,
            "notes_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(db: NotesDb): NotesDao {
        return db.notesDao()
    }

}
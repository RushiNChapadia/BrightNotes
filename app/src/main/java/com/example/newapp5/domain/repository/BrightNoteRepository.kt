package com.example.newapp5.domain.repository

import com.example.newapp5.domain.model.BrightNoteModel
import kotlinx.coroutines.flow.Flow

interface BrightNoteRepository {
    fun getAllNotes(): Flow<List<BrightNoteModel>>
}
package com.example.newapp5.data

import com.example.newapp5.data.local.NotesEntity
import com.example.newapp5.domain.Note

fun Note.toEntity(): NotesEntity = NotesEntity(
    id=id,
    title=title,
    description = description
)

fun NotesEntity.toDomain(): Note = Note(
    id=id,
    title=title,
    description = description
)
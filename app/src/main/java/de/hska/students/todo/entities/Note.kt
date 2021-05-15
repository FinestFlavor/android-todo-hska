package de.hska.students.todo.entities

import java.time.LocalDateTime

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val dateTime: LocalDateTime = LocalDateTime.now()
)

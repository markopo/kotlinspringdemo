package com.example.demo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.toList

@Service
class MessageService(val db: MessageRepository) {

    fun findMessages(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): List<Message> = db.findById(id).toList()

    fun save(message: Message) {
       db.save(message)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
    if (isPresent) listOf(get()) else emptyList()
}
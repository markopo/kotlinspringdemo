package com.example.demo

import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val service: MessageService) {

    @GetMapping("/")
    fun index() = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
        service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }
}
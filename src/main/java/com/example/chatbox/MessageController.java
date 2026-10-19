package com.example.chatbox;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRepository repo;

    public MessageController(MessageRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Message> save(@RequestBody Map<String, String> body) {
        String content = body.get("content");
        if (content == null || content.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repo.save(new Message(content)));
    }

    @GetMapping
    public List<Message> getAll() {
        return repo.findAll();
    }
}

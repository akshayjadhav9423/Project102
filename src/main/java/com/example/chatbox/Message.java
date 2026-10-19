package com.example.chatbox;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Message() {}

    public Message(String content) {
        this.content = content;
    }

    public Long getId() { return id; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

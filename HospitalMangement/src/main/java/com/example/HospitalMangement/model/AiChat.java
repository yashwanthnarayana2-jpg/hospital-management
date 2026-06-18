package com.example.HospitalMangement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ai_chat")
public class AiChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="text")
    private String text;
    @Lob
    @Column(name="response", columnDefinition = "TEXT")
    private String response;

    public AiChat() {}

    public AiChat(String text, String response) {
        this.text = text;
        this.response = response;
    }

    public Long getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
}

package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.model.AiChat;
import com.example.HospitalMangement.repository.ChatRepo;
import com.example.HospitalMangement.service.OpenAIService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class AIController {

    private final OpenAIService mistralService;
    private final ChatRepo repository;

    public AIController(OpenAIService mistralService, ChatRepo repository) {
        this.mistralService = mistralService;
        this.repository = repository;
    }

    // POST: http://localhost:8082/chat/sent
    @PostMapping("/sent")
    public AiChat sendQuery(@RequestBody AiChat request) {
        String response = mistralService.explainPrescription(request.getText());
        AiChat chat = new AiChat(request.getText(), response);
        return repository.save(chat);
    }

    // GET: http://localhost:8082/chat/recieve
    @GetMapping("/recieve")
    public List<AiChat> getChatHistory() {
        return repository.findAll();
    }
     
}

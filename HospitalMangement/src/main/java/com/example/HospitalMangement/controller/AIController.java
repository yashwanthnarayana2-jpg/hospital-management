 package com.example.HospitalMangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalMangement.model.AiChat;
import com.example.HospitalMangement.service.OpenAIService;

@RestController
 @RequestMapping("/ai")
 public class AIController {

     @Autowired
     private OpenAIService service;

     @PostMapping("/prescription")
     public String explain(@RequestBody AiChat request) {

         return service.explainPrescription(request.getText());

     }
 }
 
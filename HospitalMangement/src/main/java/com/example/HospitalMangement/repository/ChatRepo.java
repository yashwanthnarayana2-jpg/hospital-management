package com.example.HospitalMangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalMangement.model.AiChat;

public  interface ChatRepo extends JpaRepository<AiChat, Long> {

}

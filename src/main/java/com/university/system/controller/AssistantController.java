package com.university.system.controller;

import com.university.system.dto.request.AskRequest;
import com.university.system.dto.response.AskResponse;
import com.university.system.service.AssistantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ask")
public class AssistantController {

    private final AssistantService service;

    public AssistantController(AssistantService service) {
        this.service = service;
    }

    @PostMapping
    public AskResponse ask(@RequestBody AskRequest request) {
        return service.ask(request);
    }
}
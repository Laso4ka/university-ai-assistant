package com.university.system.service;

import com.university.system.dto.request.AskRequest;
import com.university.system.dto.response.AskResponse;
import com.university.system.dto.response.ToolDecision;
import com.university.system.tool.AssistantTool;
import com.university.system.tool.ToolRegistry;
import org.springframework.stereotype.Service;

@Service
public class AssistantService {

    private final ToolRegistry toolRegistry;
    private final LLMService llmService;

    public AssistantService(ToolRegistry toolRegistry, LLMService llmService) {
        this.toolRegistry = toolRegistry;
        this.llmService = llmService;
    }

    public AskResponse ask(AskRequest request) {
        ToolDecision decision = llmService.decideTool(request.question());

        AssistantTool tool = toolRegistry.getTool(decision.tool());
        if (tool == null) {
            throw new IllegalArgumentException("Unknown tool: " + decision.tool());
        }
        Object result = tool.execute(decision.arguments());
        System.out.println(result);

        String answer = llmService.generateAnswer(request.question(), result);
        return new AskResponse(answer, decision.tool());
    }
}
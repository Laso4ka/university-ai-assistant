package com.university.system.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.system.dto.response.ToolDecision;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class LLMService {

    private final ChatClient chatClient;
    private final ObjectMapper objectMapper;

    public LLMService(ChatClient.Builder builder, ObjectMapper objectMapper) {
        this.chatClient = builder.build();
        this.objectMapper = objectMapper;
    }

    public ToolDecision decideTool(String question) {

        String prompt = """
        You are a university assistant.

        Your job is to select the correct tool and extract arguments.

        Return ONLY valid JSON.

        Available tools:

        1. GET_DEPARTMENT_STATS
           arguments: { "departmentName": string }

        2. GET_STUDENT_GRADES
           arguments: { "studentName": string }

        3. FIND_COURSES_BY_LECTURER
           arguments: { "lecturerName": string }

        4. SEARCH_PEOPLE
           arguments: { "query": string }

        5. GET_TOP_STUDENTS
           arguments: { "courseName": string, "limit": number }

        Example:
        Question: Show department Computer Science stats
        Response:
        {
          "tool": "GET_DEPARTMENT_STATS",
          "arguments": {
            "departmentName": "Computer Science"
          }
        }

        Question: %s
        """.formatted(question);

        String response = chatClient
                .prompt(prompt)
                .call()
                .content();
        System.out.println("LLM request for choosing tool: " + response);
        try {
            return objectMapper.readValue(response, ToolDecision.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse LLM response: " + response);
        }
    }

    public String generateAnswer(String question, Object toolResult) {

        String prompt = """
        You are university assistant.
        
        Rules:
        - Do NOT invent any information
        - Do NOT use markdown formatting
        - Do NOT use *, **
        - Make answer inline, so no line breaks
        - Use natural language
        - Be clear and concise
        - Format numbers nicely
        - If data is missing, say it explicitly
        - Do NOT mention tools or technical details
        
        Response style:
        - Friendly but professional
        - Use short paragraphs or bullet points if helpful

        User question:
        %s
        
        Tool result:
        %s

        Generate a clear natural language answer.
        """.formatted(question, toolResult);

        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
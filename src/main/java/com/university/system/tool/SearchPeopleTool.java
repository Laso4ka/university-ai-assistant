package com.university.system.tool;

import com.university.system.service.SearchService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SearchPeopleTool implements AssistantTool {

    private final SearchService service;

    public SearchPeopleTool(SearchService service) {
        this.service = service;
    }

    @Override
    public String getName() {
        return ToolName.SEARCH_PEOPLE.name();
    }

    @Override
    public Object execute(Map<String, Object> input) {
        String query = (String) input.get("query");

        return service.search(query);
    }
}
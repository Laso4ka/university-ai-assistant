package com.university.system.service;

import com.university.system.dto.response.DepartmentStatsResponse;
import com.university.system.repository.query.DepartmentQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentQueryRepository repo;

    public DepartmentService(DepartmentQueryRepository repo) {
        this.repo = repo;
    }

    public DepartmentStatsResponse getStats(String name) {
        return repo.getDepartmentStats(name);
    }
}
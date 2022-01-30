package com.olgapoduzdikova.testmanager.service;

import com.olgapoduzdikova.testmanager.domain.ExecutionStatus;
import com.olgapoduzdikova.testmanager.repository.ExecutionStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutionStatusServiceImpl implements ExecutionStatusService{

    private final ExecutionStatusRepository executionStatusRepository;

    @Override
    public List<ExecutionStatus> getAll() {
        return executionStatusRepository.findAll();
    }
}

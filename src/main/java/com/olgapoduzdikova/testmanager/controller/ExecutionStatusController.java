package com.olgapoduzdikova.testmanager.controller;

import com.olgapoduzdikova.testmanager.domain.ExecutionStatus;
import com.olgapoduzdikova.testmanager.model.StatusDTO;
import com.olgapoduzdikova.testmanager.service.ExecutionStatusService;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("execution-statuses")
public class ExecutionStatusController extends BaseController<ExecutionStatus, StatusDTO> {

    private final ExecutionStatusService executionStatusService;

    protected ExecutionStatusController(ModelMapper mapper,
                                        ExecutionStatusService executionStatusService) {
        super(mapper);
        this.executionStatusService = executionStatusService;
    }

    @Override
    public Class<ExecutionStatus> getEntityType() {
        return ExecutionStatus.class;
    }

    @Override
    public Class<StatusDTO> getDtoType() {
        return StatusDTO.class;
    }

    @GetMapping
    List<StatusDTO> getAll() {
        return executionStatusService.getAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}

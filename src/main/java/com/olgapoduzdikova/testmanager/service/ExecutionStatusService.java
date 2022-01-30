package com.olgapoduzdikova.testmanager.service;

import com.olgapoduzdikova.testmanager.domain.ExecutionStatus;

import java.util.List;

public interface ExecutionStatusService {

    List<ExecutionStatus> getAll();
}

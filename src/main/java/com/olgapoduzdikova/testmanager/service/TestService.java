package com.olgapoduzdikova.testmanager.service;

import com.olgapoduzdikova.testmanager.domain.Test;

import java.util.List;

public interface TestService {

    List<Test> getAll();

    Test save(Test test);

    void updateTestStatus(Long id, String status);

}

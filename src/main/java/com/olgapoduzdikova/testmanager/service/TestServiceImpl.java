package com.olgapoduzdikova.testmanager.service;

import com.olgapoduzdikova.testmanager.domain.Test;
import com.olgapoduzdikova.testmanager.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public List<Test> getAll() {
        return testRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    @Override
    @Transactional
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    @Transactional
    public void updateTestStatus(Long id, String status) {
        testRepository.updateStatus(id, status);
    }
}

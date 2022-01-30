package com.olgapoduzdikova.testmanager.controller;

import com.olgapoduzdikova.testmanager.domain.Test;
import com.olgapoduzdikova.testmanager.model.TestDTO;
import com.olgapoduzdikova.testmanager.service.TestService;
import com.olgapoduzdikova.testmanager.validation.Create;
import com.olgapoduzdikova.testmanager.validation.UpdateStatus;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tests")
public class TestController extends BaseController<Test, TestDTO>{

    private final TestService testService;

    protected TestController(ModelMapper mapper,
                             TestService testService) {
        super(mapper);
        this.testService = testService;
    }

    @Override
    public Class<Test> getEntityType() {
        return Test.class;
    }

    @Override
    public Class<TestDTO> getDtoType() {
        return TestDTO.class;
    }

    @GetMapping
    List<TestDTO> getAll() {
        return testService.getAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    TestDTO save(@Validated(Create.class) @RequestBody TestDTO test) {
        return convertToDto(testService.save(convertToEntity(test)));
    }

    @PatchMapping("{id}/status")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void updateStatus(@PathVariable Long id, @Validated(UpdateStatus.class) @RequestBody TestDTO test) {
        testService.updateTestStatus(id, test.getStatus());
    }
}

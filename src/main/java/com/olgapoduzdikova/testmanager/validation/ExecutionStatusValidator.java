package com.olgapoduzdikova.testmanager.validation;

import com.olgapoduzdikova.testmanager.repository.ExecutionStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ExecutionStatusValidator implements ConstraintValidator<ExecutionStatusConstraint, String> {

    private final ExecutionStatusRepository executionStatusRepository;

    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {
        if(status == null) {
            return true;
        }

        return executionStatusRepository.existsById(status);
    }
}

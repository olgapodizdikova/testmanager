package com.olgapoduzdikova.testmanager.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = ExecutionStatusValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecutionStatusConstraint {
    String message() default "{status.invalid.type}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

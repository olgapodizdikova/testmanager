package com.olgapoduzdikova.testmanager.model;

import com.olgapoduzdikova.testmanager.validation.Create;
import com.olgapoduzdikova.testmanager.validation.ExecutionStatusConstraint;
import com.olgapoduzdikova.testmanager.validation.UpdateStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class TestDTO {
    @Null(groups = {Create.class}, message = "id.null")
    private Long id;
    @NotBlank(groups = {Create.class}, message = "{name.not.blank}")
    @Size(max = 255, message = "{name.size}")
    private String name;
    @ExecutionStatusConstraint(groups = {UpdateStatus.class, Create.class})
    @NotNull(groups = {UpdateStatus.class}, message = "status.not.null")
    private String status;
}

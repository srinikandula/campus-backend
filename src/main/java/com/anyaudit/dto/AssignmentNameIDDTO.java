package com.anyaudit.dto;

import com.anyaudit.models.Assignment;
import com.anyaudit.models.BaseModel;
import com.anyaudit.models.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AssignmentNameIDDTO  {
    private Long id;
    private String assignmentName;
    public AssignmentNameIDDTO(Assignment assignment) {
        this.id = assignment.getId();
        this.assignmentName = assignment.getAssignmentName();
    }
}

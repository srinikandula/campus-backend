package com.anyaudit.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "milestone")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String assignmentname;

    @NotBlank
    @Size(max = 30)
    private String milestoneName;

    @NotBlank
    @Size(max = 30)
    private String checkeruser;

    @NotBlank
    @Size(max = 30)
    private String team;

    @NotBlank
    @Size(max = 20)
    private String startdate;

    @NotBlank
    @Size(max = 20)
    private String enddate;
}

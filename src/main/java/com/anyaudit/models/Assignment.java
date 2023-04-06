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
@Table(name = "assignment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String assignmentname;

    @NotBlank
    @Size(max = 50)
    private String typeofassignment;

    @NotBlank
    @Size(max = 20)
    private String clientname;

    @NotBlank
    @Size(max = 8)
    private String financialyear;

    @NotBlank
    @Size(max = 30)
    private String engagementpartner;

    @NotBlank
    @Size(max = 20)
    private String reviewpartner;

    @NotBlank
    @Size(max = 20)
    private String users;

    @NotBlank
    @Size(max = 20)
    private String value;

    @NotBlank
    @Size(max = 20)
    private String startdate;

    @NotBlank
    @Size(max = 20)
    private String enddate;


}

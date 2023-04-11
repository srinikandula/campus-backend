package com.anyaudit.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assignment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Long id;

    @Column(name = "assignment_name")
    private String assignmentName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "type_of_assignment")
    private String typeofAssignment;


    @NotBlank
    @Size(max = 8)
    @Column(name = "financial_year")
    private String financialYear;

    @NotBlank
    @Size(max = 30)
    @Column(name = "engagement_partner")
    private String engagementPartner;

    @NotBlank
    @Size(max = 20)
    @Column(name = "review_partner")
    private String reviewPartner;

    @NotBlank
    @Size(max = 20)
    @Column(name = "users")
    private String users;

    @NotBlank
    @Size(max = 20)
    @Column(name = "value")
    private String value;

//    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(name = "startdate")
    private Date startDate;

//    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(name = "enddate")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;
}

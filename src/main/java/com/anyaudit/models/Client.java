package com.anyaudit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client extends BaseModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private Long id;

  @NotBlank
  @Column(name = "name")
  private String name;

  @NotBlank
  @Size(max = 50)
  @Column(name = "phone_no")
  private String phoneNo;

  @NotBlank
  @Size(max = 50)
  @Column(name = "email")
  private String email;

  @NotBlank
  @Size(max = 50)
  @Column(name = "file_no")
  private String fileNo;

  @NotBlank
  @Size(max = 50)
  @Column(name = "financial_framework")
  private String financialFramework;

}

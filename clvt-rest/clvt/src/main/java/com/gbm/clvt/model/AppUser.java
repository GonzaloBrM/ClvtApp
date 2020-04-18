package com.gbm.clvt.model;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AppUser {

  @Id
  @EqualsAndHashCode.Exclude
  private String id;
  @NotNull
  private String name;
  @NotNull
  @EqualsAndHashCode.Exclude
  private String password;
  @NotNull
  private List<String> rol;

  public AppUser(String name, String password, String... rol) {
    this.name = name;
    this.password = password;
    this.rol = rol == null ? null : Arrays.asList(rol);
  }

}
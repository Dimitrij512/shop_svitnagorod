package com.shop.svitnagorod.DTO;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.model.UserRole;

public class UserDTO implements Serializable {

  private static final long serialVersionUID = -535163477185539183L;

  private Integer id;
  private String name;
  private String surname;
  private String login;
  private String password;
  private MultipartFile avatar;
  private String role = UserRole.CUSTOMER.getUserRole();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public MultipartFile getAvatar() {
    return avatar;
  }

  public void setAvatar(MultipartFile avatar) {
    this.avatar = avatar;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}

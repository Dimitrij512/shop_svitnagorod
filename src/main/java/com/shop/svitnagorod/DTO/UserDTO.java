package com.shop.svitnagorod.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.model.UserRole;

public class UserDTO implements Serializable {

  private static final long serialVersionUID = -535163477185539183L;

  private Integer id;
  private String name;
  private String surname;
  private String login;
  private String password;
  private String phone;
  private MultipartFile avatar;
  private String role = UserRole.CUSTOMER.getUserRole();

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @NotBlank(message = "Ви не ввели ваше ім'я")
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @NotBlank(message = "Ви не ввели вашу фамілію")
  @Column(name = "surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @NotBlank(message = "Ви не ввели пароль")
  @Column(name = "login")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @NotBlank(message = "Ви не ввели ваш @mail")
  @Column(name = "login")
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, true);

  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, true);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}

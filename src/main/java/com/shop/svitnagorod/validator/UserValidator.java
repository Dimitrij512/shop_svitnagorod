package com.shop.svitnagorod.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shop.svitnagorod.model.User;
import com.shop.svitnagorod.service.UserService;

@Component
public class UserValidator implements Validator {

  @Autowired
  UserService userServiceImpl;

  @Override
  public boolean supports(Class<?> clazz) {
    return User.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    User user = (User) target;
    if (!userServiceImpl.isUserUnique(user.getLogin(), user.getId())) {
      errors.rejectValue("login", "NotUnique.login");
    }

  }

}

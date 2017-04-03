package com.shop.svitnagorod.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.DTO.UserDTO;
import com.shop.svitnagorod.service.UserService;

@Component
public class UserValidator implements Validator {

  @Autowired
  UserService userServiceImpl;

  @Override
  public boolean supports(Class<?> clazz) {
    // return UserDTO.class.equals(clazz);
    return UserDTO.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    String regexPhoneNumber = "^\\+380([0-9]?){9,11}[0-9]$";
    UserDTO user = (UserDTO) target;
    String phoneNumber = user.getPhone();
    MultipartFile avatar = user.getAvatar();

    if (!userServiceImpl.isUserUnique(user.getLogin(), user.getId())) {
      errors.rejectValue("login", "NotUnique.login");
    }

    if (!checkInput(regexPhoneNumber, phoneNumber)) {
      errors.rejectValue("phone", "BadNumber.phone");
    }

    if (!avatar.isEmpty()
        && !(avatar.getContentType().equals("image/png") || avatar.getContentType().equals("image/jpeg"))) {
      errors.rejectValue("avatar", "BadAvatar.avatar");
    }

  }

  public boolean checkInput(String regex, String input) {
    if (input == null || input.length() == 0) {
      return true;
    }
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);
    if (m.find()) {
      return true;
    } else {
      return false;
    }
  }
}

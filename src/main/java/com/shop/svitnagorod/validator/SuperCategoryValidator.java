package com.shop.svitnagorod.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shop.svitnagorod.DTO.SuperCategoryDTO;

public class SuperCategoryValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {

    return SuperCategoryDTO.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    SuperCategoryDTO category = (SuperCategoryDTO) target;

  }

}

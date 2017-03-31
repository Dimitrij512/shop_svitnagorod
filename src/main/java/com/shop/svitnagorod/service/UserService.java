package com.shop.svitnagorod.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shop.svitnagorod.DTO.UserDTO;
import com.shop.svitnagorod.model.Users;

public interface UserService {

	void save(UserDTO userDTO);

	void saveUser(Users users);

	void delete(int id);

	Users findById(int id);

	Users findByLogin(String login);

	boolean isUserUnique(String login, Integer id);

	List<Users> findAllUser();

	void authenticateUserAndSetSession(Users users, HttpServletRequest request);

}

package com.shop.svitnagorod.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.DAO.UserDao;
import com.shop.svitnagorod.DTO.UserDTO;
import com.shop.svitnagorod.model.Users;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	@Autowired
	protected AuthenticationManager authenticationManager;

	@Autowired
	GeneralService generalService;

	@Transactional
	@Override
	public void save(UserDTO userDTO) {
		Users user = new Users();
		user.setId(userDTO.getId());
		user.setSurname(userDTO.getSurname());
		user.setName(userDTO.getName());
		user.setLogin(userDTO.getLogin());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhone());
		user.setRole(userDTO.getRole());
		MultipartFile avatar = userDTO.getAvatar();
		try {
			if (avatar.isEmpty()) {
				user.setAvatar(generalService.getDefoultImageUser());
			} else {
				user.setAvatar(avatar.getBytes());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			dao.save(user);
		} catch (DataAccessException dae) {
			System.out.println(dae);
		}
	}

	@Transactional
	@Override
	public Users findById(int id) {
		return dao.findById(id);
	}

	@Transactional
	@Override
	public Users findByLogin(String login) {

		return dao.findByLogin(login);
	}

	@Transactional
	@Override
	public boolean isUserUnique(String login, Integer id) {
		Users user = null;
		user = findByLogin(login);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

	@Transactional
	@Override
	public List<Users> findAllUser() {

		return dao.findAllUsers();
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);

	}

	@Transactional
	@Override
	public void saveUser(Users users) {
		dao.save(users);

	}

	@Override
	public void authenticateUserAndSetSession(Users users, HttpServletRequest request) {
		String username = users.getLogin();
		String password = users.getPassword();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

		// generate session if one doesn't exist
		request.getSession();

		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

	}
}

package com.shop.svitnagorod.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.svitnagorod.DAO.UserDao;
import com.shop.svitnagorod.model.User;

@Service
public class MyUserDatailsService implements UserDetailsService {

  @Autowired
  private UserDao userDAO;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    final User user = userDAO.findByLogin(login);

    if (user == null) {
      throw new UsernameNotFoundException(login);
    }
    return new org.springframework.security.core.userdetails.User(login, user.getPassword(), true, true, true, true,
        Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
  }

}

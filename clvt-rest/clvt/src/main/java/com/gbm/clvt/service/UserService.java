package com.gbm.clvt.service;

import java.util.ArrayList;
import java.util.List;

import com.gbm.clvt.model.AppUser;
import com.gbm.clvt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    AppUser user = repository.findByName(name);

    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    user.getRol().forEach((r) -> {
      authorities.add(new SimpleGrantedAuthority("ROLE_" + r));
    });

    UserDetails userDetails = new User(user.getName(), user.getPassword(), authorities);

    return userDetails;
  }

}
package com.isa_mrs.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa_mrs.project.model.User;
import com.isa_mrs.project.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	 @Autowired
	 private AuthenticationManager authenticationManager;
	
	 @Autowired
	 private UserAuthorityService userAuthService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepo.findByEmail(username);
	        if (user == null) {
	            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	        } else {
	            return user;
	        }
	}
	
	public User create(User entity) throws Exception {
		if(userRepo.findByEmail(entity.getEmail()) != null){
            throw new Exception("User with given email already exists");
        }
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepo.save(entity);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}
}

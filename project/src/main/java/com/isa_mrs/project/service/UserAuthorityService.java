package com.isa_mrs.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs.project.model.Authority;
import com.isa_mrs.project.model.User;
import com.isa_mrs.project.model.UserAuthority;
import com.isa_mrs.project.repository.UserAuthorityRepository;

@Service
public class UserAuthorityService {

	@Autowired
	UserAuthorityRepository userAuthorityRepo;

	@Autowired
	UserService userService;
	
	@Autowired
	AuthorityService authService;
	
	public UserAuthority create(Long userId, String role) throws Exception {
		User user = userService.findById(userId);
		Authority authority = authService.findByName(role);
		
		UserAuthority userAuth = new UserAuthority(user,authority);
		if(userAuthorityRepo.findByAuthorityIdAndUserId(authority.getId(),user.getId()) != null){
            throw new Exception("Cultural content category with given name already exists");
        }
        return userAuthorityRepo.save(userAuth);
	}
}

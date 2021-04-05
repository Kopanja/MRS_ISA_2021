package com.isa_mrs.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs.project.dto.LoginDTO;
import com.isa_mrs.project.dto.UserDTO;
import com.isa_mrs.project.model.User;
import com.isa_mrs.project.service.UserAuthorityService;
import com.isa_mrs.project.service.UserService;

@RestController
@RequestMapping(value="api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserAuthorityService userAuthService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        
		List<User> users = userService.findAll();
        return new ResponseEntity<>(toUserDTOList(users), HttpStatus.OK);
    }
	
	 
	 private static User toUserFromLoginDTO(LoginDTO loginInfo) {
		 User user = new User();
		 user.setEmail(loginInfo.getEmail());
		 user.setPassword(loginInfo.getPassword());
		 return user;
	 }
	 
	 private List<UserDTO> toUserDTOList(List<User> users) {
	        List<UserDTO> usersDTOS = new ArrayList<>();
	       
	        for (User user: users) {
	            usersDTOS.add(new UserDTO(user.getId(), user.getEmail()));
	        }
	        return usersDTOS;
	    }
	 
	 

}

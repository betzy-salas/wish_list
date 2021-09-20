package com.msuser.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.msuser.domain.User;
import com.msuser.interfaces.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService _userService;
	
	@PostMapping
	public @ResponseBody ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(_userService.save(user));
	}
	
	@GetMapping(value = "/{username}")
	public @ResponseBody ResponseEntity<Optional<User>> checkUser(@Valid @PathVariable String username) throws Exception {
		Optional<User> userFound = _userService.findByUsername(username);
		if(!userFound.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(userFound);
		else {	
			throw new Exception();
		}
	}
	
	@GetMapping("/userId/{idUser}")
	public @ResponseBody ResponseEntity<Optional<User>> checkUserById(@Valid @PathVariable int idUser) throws Exception {
		Optional<User> userFound = _userService.findByIdUser(idUser);
		if(!userFound.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(userFound);
		else {	
			throw new Exception();
		}
	}

}
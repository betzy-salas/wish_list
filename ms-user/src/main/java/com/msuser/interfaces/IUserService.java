package com.msuser.interfaces;

import java.util.Optional;

import com.msuser.domain.User;

public interface IUserService {
	
	public User save(User user);
	
	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByIdUser(int idUser);

}

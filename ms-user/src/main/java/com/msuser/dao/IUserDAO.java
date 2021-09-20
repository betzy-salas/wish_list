package com.msuser.dao;

import org.springframework.data.repository.CrudRepository;

import com.msuser.domain.User;

public interface IUserDAO extends CrudRepository<User, String> {
	
	public User findByUsername(String username);
	
	public User findByIdUser(int idUser);

}

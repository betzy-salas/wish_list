package com.msuser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msuser.dao.IUserDAO;
import com.msuser.domain.User;
import com.msuser.interfaces.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserDAO _userDAO;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return _userDAO.save(user);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(Optional.ofNullable(_userDAO.findByUsername(username)).orElse(null));
	}

	@Override
	public Optional<User> findByIdUser(int idUser) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(Optional.ofNullable(_userDAO.findByIdUser(idUser)).orElse(null));
	}


}

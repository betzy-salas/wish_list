package com.ms_wish_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms_wish_list.client.IUserClient;
import com.ms_wish_list.dao.IWishListDAO;
import com.ms_wish_list.domain.WishList;
import com.ms_wish_list.interfaces.IWishListService;
import com.ms_wish_list.model.User;

@Service
public class WishListService implements IWishListService{

	@Autowired
	IWishListDAO _wishListDAO;
	
	@Autowired
	IUserClient userClient;
	
	@Override
	public WishList save(WishList wishList) {
		// TODO Auto-generated method stub
		
		boolean isFound = true;
		
		try {
			ResponseEntity<Optional<User>> user = userClient.checkUserById(wishList.getIdUser());
		} catch (Exception e) {
			isFound = false;
			e.printStackTrace();
		}
	
		if (isFound)
			return _wishListDAO.save(wishList);
		
		return null;
	}

	@Override
	public Optional<WishList> findById(int idWishList) {
		// TODO Auto-generated method stub
		return _wishListDAO.findById(idWishList);
	}

	@Override
	public List<WishList> findAll() {
		// TODO Auto-generated method stub
		return (List<WishList>)_wishListDAO.findAll();
	}

	@Override
	public boolean deleteWishId(int idWishList) {
		// TODO Auto-generated method stub
		Optional<WishList> wishList = findById(idWishList);
        if (wishList.isEmpty()){
            return false;
        } else {
        	_wishListDAO.deleteById(idWishList);
        	return true;
        }
	}
}

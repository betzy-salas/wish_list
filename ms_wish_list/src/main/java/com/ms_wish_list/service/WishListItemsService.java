package com.ms_wish_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_wish_list.dao.IWishListDAO;
import com.ms_wish_list.dao.IWishListItemsDAO;
import com.ms_wish_list.domain.WishListItems;
import com.ms_wish_list.interfaces.IWishListItemsService;

@Service
public class WishListItemsService implements IWishListItemsService{

	@Autowired
	IWishListItemsDAO _wishListItemsDAO;
	
	@Autowired
	IWishListDAO _wishListDAO;
	
	@Override
	public WishListItems save(WishListItems wishListItems) {
		return _wishListItemsDAO.save(wishListItems);
	}

	@Override
	public Optional<WishListItems> findById(int idWishListItem) {
		return _wishListItemsDAO.findById(idWishListItem);
	}

	@Override
	public List<WishListItems> findAll() {
		return (List<WishListItems>)_wishListItemsDAO.findAll();
	}

	@Override
	public boolean deleteWishItemsId(int idWishListItem) {
		Optional<WishListItems> wishListItems = _wishListItemsDAO.findById(idWishListItem);
        if (wishListItems.isEmpty()){
            return false;
        } else {
        	_wishListItemsDAO.deleteById(idWishListItem);
        	return true;
        }
	}

	@Override
	public List<WishListItems> findByIdWishList(Integer idWishListId) {
		List<WishListItems> wishListItems = _wishListItemsDAO.findByIdWishList(idWishListId);
		return wishListItems; 
	}

	@Override
	public boolean deleteWishItemsAll(Integer idWishListId) {
		List<WishListItems> wishListItems = findByIdWishList(idWishListId);
        if (wishListItems.isEmpty()){
            return false;
        } else {
        	wishListItems.forEach(items->{deleteWishItemsId(items.getIdItem());});
        	return true;
        }
	}
	

}

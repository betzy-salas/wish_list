package com.ms_wish_list.interfaces;

import java.util.List;
import java.util.Optional;

import com.ms_wish_list.domain.WishListItems;

public interface IWishListItemsService {
	public WishListItems save(WishListItems wishListItems);
	public Optional<WishListItems> findById(int idItems);
	public List<WishListItems> findAll();
	public boolean deleteWishItemsId(int idItems);
	public List<WishListItems> findByIdWishList(Integer idWishListId);
	public boolean deleteWishItemsAll(Integer idWishListId);
}

package com.ms_wish_list.interfaces;

import java.util.List;
import java.util.Optional;

import com.ms_wish_list.domain.WishList;

public interface IWishListService {
	public WishList save(WishList wishList);
	public Optional<WishList> findById(int idWishList);
	public List<WishList> findAll();
	public boolean deleteWishId(int idWishList);
}

package com.ms_wish_list.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ms_wish_list.domain.WishListItems;

public interface IWishListItemsDAO extends CrudRepository<WishListItems, Integer> {
	public List<WishListItems> findByIdWishList(Integer idWishList);
}


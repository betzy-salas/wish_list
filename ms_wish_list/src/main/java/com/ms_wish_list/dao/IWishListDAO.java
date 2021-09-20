package com.ms_wish_list.dao;
import org.springframework.data.repository.CrudRepository;

import com.ms_wish_list.domain.WishList;

public interface IWishListDAO extends CrudRepository<WishList, Integer> {
		
}


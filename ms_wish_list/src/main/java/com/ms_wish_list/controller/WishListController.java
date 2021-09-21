package com.ms_wish_list.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms_wish_list.domain.WishList;
import com.ms_wish_list.exception.UserNotFound;
import com.ms_wish_list.exception.WishNotFound;
import com.ms_wish_list.interfaces.IWishListService;

@RequestMapping("/wishlist")
@RestController
public class WishListController {

	@Autowired
	private IWishListService _wishListService;
	
	@PostMapping
	public @ResponseBody ResponseEntity<WishList> createWishList(@Valid @RequestBody WishList wishList) throws UserNotFound {
		
		WishList wishSaved = _wishListService.save(wishList);
		if (wishSaved != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(_wishListService.save(wishList));
		else
			throw new UserNotFound("");
		
	}
	
	@GetMapping("/{idWishList}")
	public @ResponseBody ResponseEntity<Optional<WishList>> checkWishList(@Valid @PathVariable int idWishList) throws WishNotFound{
		Optional<WishList> wishListFound = _wishListService.findById(idWishList);
		if(!wishListFound.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(wishListFound);
		else 
			throw new WishNotFound("");
	}
	
	@GetMapping("/wishlists")
	public @ResponseBody ResponseEntity<List<WishList>> checkWishListAll() throws WishNotFound{
		List<WishList> wishListFound = _wishListService.findAll();
		if(!wishListFound.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(wishListFound);
		else 	
			throw new WishNotFound("");
	}
	
    @DeleteMapping(value = "/{idWishList}")
    public ResponseEntity<Boolean> deleteWishList(@PathVariable int idWishList) throws WishNotFound {
    	if(_wishListService.deleteWishId(idWishList))
    		return ResponseEntity.status(HttpStatus.OK).body(true);
		else 	
			throw new WishNotFound("");
    }
}

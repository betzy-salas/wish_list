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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms_wish_list.domain.WishListItems;
import com.ms_wish_list.exception.UserNotFound;
import com.ms_wish_list.exception.WishListItemNotFound;
import com.ms_wish_list.interfaces.IWishListItemsService;

@RestController
public class WishListItemsController {

	@Autowired
	private IWishListItemsService _wishListItemsService;
	
	@PostMapping("/wishlistItems")
	public @ResponseBody ResponseEntity<WishListItems> createWishListItems(@Valid @RequestBody WishListItems wishListItems) throws UserNotFound {
		
		WishListItems wishListItemesSaved = _wishListItemsService.save(wishListItems);
		if (wishListItemesSaved != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(_wishListItemsService.save(wishListItems));
		else
			throw new UserNotFound("");
		
	}
	
	@GetMapping("/wishlistItems/{idWishListItems}")
	public @ResponseBody ResponseEntity<Optional<WishListItems>> checkWishList(@Valid @PathVariable int idWishListItems) throws WishListItemNotFound{
		Optional<WishListItems> wishListItemsFound = _wishListItemsService.findById(idWishListItems);
		if(!wishListItemsFound.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(wishListItemsFound);
		else 
			throw new WishListItemNotFound("");
	}
	
	@GetMapping("/wishlistsItems")
	public @ResponseBody ResponseEntity<List<WishListItems>> checkWishListItemsAll() throws WishListItemNotFound{
		List<WishListItems> wishListItemsFound = _wishListItemsService.findAll();
		if(!wishListItemsFound.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(wishListItemsFound);
		else 	
			throw new WishListItemNotFound("");
	}
	
    @DeleteMapping(value = "/wishlistItems/wishListItem/{idWishListItems}")
    public ResponseEntity<Boolean> deleteWishList(@PathVariable int idWishListItems) throws WishListItemNotFound {
    	if(_wishListItemsService.deleteWishItemsId(idWishListItems))
    		return ResponseEntity.status(HttpStatus.OK).body(true);
		else 	
			throw new WishListItemNotFound("");
    }
    
	@GetMapping("/wishlistsItems/idWishListAll/{idWishList}")
	public @ResponseBody ResponseEntity<List<WishListItems>> checkWishItemsAll(@PathVariable Integer idWishList) throws WishListItemNotFound{
		List<WishListItems> wishListItemsFound = _wishListItemsService.findByIdWishList(idWishList);
		if(!wishListItemsFound.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(wishListItemsFound);
		else 	
			throw new WishListItemNotFound("");
	}
	
    @DeleteMapping(value = "/wishlistItems/idWishList/{idWishList}")
    public ResponseEntity<Boolean> deleteWishListItemsAll(@PathVariable Integer idWishList) throws WishListItemNotFound {
    	if(_wishListItemsService.deleteWishItemsAll(idWishList))
    		return ResponseEntity.status(HttpStatus.OK).body(true);
		else 	
			throw new WishListItemNotFound("");
    }
}

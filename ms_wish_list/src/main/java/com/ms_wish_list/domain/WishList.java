package com.ms_wish_list.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ms_wish_list.model.User;

@Entity
@Table(name = "wishList")
public class WishList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idWishList")
	private Integer idWishList;

	@Column(name = "idUser", nullable = false)
	private int idUser;

	@Column(name = "wishListName", nullable = false, length = 50)
	private String wishListName;
	
	@Transient
	private User user;

	public Integer getIdWishList() {
		return idWishList;
	}

	public void setIdWishList(Integer idWishList) {
		this.idWishList = idWishList;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getWishListName() {
		return wishListName;
	}

	public void setWishListName(String wishListName) {
		this.wishListName = wishListName;
	}

}

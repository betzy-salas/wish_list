package com.ms_wish_list.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;


@Entity
@Table(name = "wishListItems")
public class WishListItems implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idItem")
	private Integer idItem;
	
	@Column(name = "idWishList", nullable = false)
	private int idWishList;

	@Column(name = "bookId", nullable = false, length = 30)
	private String bookId;

	@Column(name = "bookAuthor", nullable = false, length = 500)
	private String bookAuthor;
	
	@Column(name = "bookTitle", nullable = false, length = 200)
	private String bookTitle;
	
	@Column(name = "bookPublisher", nullable = false, length = 200)
	private String bookPublisher;
	
	@ManyToOne
	@JoinColumn(name="idWishList", insertable=false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private WishList wishList;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public int getIdWishList() {
		return idWishList;
	}

	public void setIdWishList(int idWishList) {
		this.idWishList = idWishList;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public WishList getWishList() {
		return wishList;
	}

	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}
	
	

}

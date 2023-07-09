package com.example.AvanzaSolutionsBookStore.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="checkout_cart")
public class CheckoutCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String order_id;
	String payment_type;
	String delivery_address;
	long user_id;
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "book_id")
	Books books;	
	int qty;
	double price;
	@Column(updatable=false, insertable=false)
	String order_date;
}


package com.example.AvanzaSolutionsBookStore.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "add_to_cart")
public class AddtoCart {
	@Id
	long id;
	@JsonIgnore
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "book_id")
	Books books;
	int qty;
	double price;
	Long user_id;
	@Column(updatable=false, insertable=false)
	String added_date;
	
}

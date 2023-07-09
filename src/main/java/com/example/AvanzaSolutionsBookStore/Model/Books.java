package com.example.AvanzaSolutionsBookStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="books")
public class Books {
	@Id
	long id;
	
	String name;
	String price;
	String added_on;
	String category_id;
	
}

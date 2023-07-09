package com.example.AvanzaSolutionsBookStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="category")//have to add
public class Category {
	@Id
	long id;
	String name;
	
}


package com.example.AvanzaSolutionsBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AvanzaSolutionsBookStore.Model.Category;


public interface CategoryRepo  extends JpaRepository<Category, Long> {

}


package com.example.AvanzaSolutionsBookStore.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AvanzaSolutionsBookStore.Model.Books;
import com.example.AvanzaSolutionsBookStore.Model.Category;
import com.example.AvanzaSolutionsBookStore.Repository.BooksRepo;
import com.example.AvanzaSolutionsBookStore.Repository.CategoryRepo;


@Service
public class BookServiceImpl {

	@Autowired
	BooksRepo booksRepo;
	
	@Autowired
	CategoryRepo cateRepo;
	
	public List<Books>getAllBooks(){
		return booksRepo.findAll();
	}
	public List<Books>getBooksByCategory(String book_id){
		return booksRepo.getByCategoryId(book_id);
	}
	
	public List<Category>getAllCategory(){
		return cateRepo.findAll();
	}
	
	public Books getBooksById(long bookId) throws Exception {
		return booksRepo.findById(bookId).orElseThrow(() ->new Exception("Book is not found"));
	}
}


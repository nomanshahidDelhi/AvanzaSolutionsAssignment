package com.example.AvanzaSolutionsBookStore.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AvanzaSolutionsBookStore.Model.Books;
import com.example.AvanzaSolutionsBookStore.Model.Category;
import com.example.AvanzaSolutionsBookStore.ServiceImpl.BookServiceImpl;

@RestController
@RequestMapping("api/book")
public class BookController {
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@GetMapping("getAll")
	public List<Books> getAllBooks(){
		return bookServiceImpl.getAllBooks();
	}
	@GetMapping("getAllCategory")
	public List<Category> getAllCategory(){
		return bookServiceImpl.getAllCategory();
	}
	
	@GetMapping("getBooksByCategory")
	public List<Books> getBooksByCategory(@RequestBody HashMap<String,String> request){
		String category_id = request.get("cat_id");		
		return bookServiceImpl.getBooksByCategory(category_id);
	}
	
}


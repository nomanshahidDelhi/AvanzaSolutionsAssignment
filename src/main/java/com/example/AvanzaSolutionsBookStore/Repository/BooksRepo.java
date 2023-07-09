package com.example.AvanzaSolutionsBookStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AvanzaSolutionsBookStore.Model.Books;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long> {
	@Query("Select book FROM Books book WHERE book.category_id=:cat_id")
	List<Books> getByCategoryId(@Param("cat_id")String cat_id);
}


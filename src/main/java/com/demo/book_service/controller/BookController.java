package com.demo.book_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book_service.dao.BookRepository;
import com.demo.book_service.model.BookEntity;

@RestController
@RequestMapping("api")
public class BookController {
	
	@Autowired
	BookRepository bookRepo;
	
	@GetMapping("/books")
	public List<BookEntity> getAllBooks()
	{
		return this.bookRepo.findAll();
	}
	
	@GetMapping("/books/{bid}")
	public BookEntity getABook(@PathVariable long bid) {
		return this.bookRepo.findById(bid).get();
	}
	
	@PostMapping("/books")
	public BookEntity addBook(@RequestBody BookEntity newBook)
	{
		return this.bookRepo.saveAndFlush(newBook);
	}
	
	@DeleteMapping("/books/{bid}")
	public void deleteBook(@PathVariable long bid) {
		this.bookRepo.deleteById(bid);
	}
}

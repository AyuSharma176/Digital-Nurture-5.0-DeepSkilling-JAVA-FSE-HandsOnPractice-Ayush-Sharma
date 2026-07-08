package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    // CREATE
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // READ ALL
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {

        Book existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        repository.deleteById(id);
        return "Book Deleted Successfully";
    }
}
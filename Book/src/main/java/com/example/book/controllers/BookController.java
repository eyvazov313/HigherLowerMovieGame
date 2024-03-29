package com.example.book.controllers;

import com.example.book.dto.book.request.BookCreateRequest;
import com.example.book.dto.book.response.AllBooksResponse;
import com.example.book.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<AllBooksResponse> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/{authorId}")
    public void add(@RequestBody BookCreateRequest bookRequest, @PathVariable int authorId) {
        bookService.add(bookRequest, authorId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}

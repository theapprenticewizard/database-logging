package com.theapprenticewizard.databaselogging.controller;

import com.theapprenticewizard.databaselogging.model.Book;
import com.theapprenticewizard.databaselogging.model.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/find-any")
    public Book findAny() {
        return bookService.generateRandom();
    }
}

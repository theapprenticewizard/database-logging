package com.theapprenticewizard.databaselogging.model;

import com.theapprenticewizard.databaselogging.application.Loggable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Loggable
public class BookServiceImpl implements BookService {
    public Book generateRandom() {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setIsbn(UUID.randomUUID().toString());
        book.setTitle("not a very good book");
        return  book;
    }
}

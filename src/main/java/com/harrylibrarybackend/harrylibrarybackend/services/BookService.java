package com.harrylibrarybackend.harrylibrarybackend.services;

import com.harrylibrarybackend.harrylibrarybackend.exceptions.BookNotFoundException;
import com.harrylibrarybackend.harrylibrarybackend.models.Book;
import com.harrylibrarybackend.harrylibrarybackend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long id) {
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new BookNotFoundException("Book by id " + id + " was not found"));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBookById(id);
    }
}

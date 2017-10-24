package com.kvatronix.service;

import com.kvatronix.dao.BookDAO;
import com.kvatronix.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public void createBook(Book book) {
        this.bookDAO.createBook(book);

    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(int bookId) {
        this.bookDAO.deleteBook(bookId);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public Book getBook(int bookId) {
        return this.bookDAO.getBook(bookId);
    }

    @Override
    public List<Book> searhBooks(String title) {
        List<Book> findBooks = new ArrayList<>();
        for (Book book:this.bookDAO.getAllBooks()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                findBooks.add(book);
            }
        }
        return findBooks;
    }
}

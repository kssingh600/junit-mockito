package com.kdacademy.junit.mockitodemo.test_doubles.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DummyTest {
    
    @Test
    public void demoDummy(){
        BookRepository bookRepository = new FakeBookRepository() ;
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository, emailService) ;
        bookService.addBook(new Book("1", "Mockito In Action", 250, LocalDate.now()));
        bookService.addBook(new Book("2", "JUnit5 In Action", 350, LocalDate.now()));
        assertEquals(2, bookService.findNumberOfBooks());
    }

    @Test
    public void demoDummyWithMockito(){
        BookRepository bookRepository = Mockito.mock(BookRepository.class) ;
        EmailService emailService = Mockito.mock(EmailService.class) ;
        BookService bookService = new BookService(bookRepository, emailService) ;
        Book book1 = new Book("1", "Mockito In Action", 250, LocalDate.now()) ;
        Book book2 = new Book("2", "JUnit5 In Action", 350, LocalDate.now()) ;
        Collection<Book> books = new ArrayList<>() ;
        books.add(book1) ;
        books.add(book2) ;
        Mockito.when(bookRepository.findAll()).thenReturn(books) ;
        assertEquals(2, bookService.findNumberOfBooks());
    }
}

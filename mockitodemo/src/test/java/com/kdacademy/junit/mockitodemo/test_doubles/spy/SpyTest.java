package com.kdacademy.junit.mockitodemo.test_doubles.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.mockito.Mockito;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class SpyTest {
    @Test
    public void demoSpy(){
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy() ;
        BookService bookService = new BookService(bookRepositorySpy) ;
        Book book1 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        Book book2 = new Book("2", "JUnit5 In Action", 400, LocalDate.now()) ;
        bookService.addBook(book1);
        assertEquals(0, bookRepositorySpy.timesCalled());
        bookService.addBook(book2);
        assertEquals(1, bookRepositorySpy.timesCalled());
        assertTrue(bookRepositorySpy.calledWith(book2));
    }

    @Test
    public void demoSpyWithMockito(){
        BookRepository bookRepositorySpy = spy(BookRepository.class) ;
        BookService bookService = new BookService(bookRepositorySpy) ;
       
        Book book1 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        Book book2 = new Book("2", "JUnit5 In Action", 400, LocalDate.now()) ;
        
        bookService.addBook(book1); //return
        bookService.addBook(book2); //save will be called

        // verify(bookRepositorySpy).save(book2);
        verify(bookRepositorySpy, Mockito.times(1)).save(book2);
        verify(bookRepositorySpy, Mockito.times(0)).save(book1);
    }
}

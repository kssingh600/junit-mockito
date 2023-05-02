package com.kdacademy.junit.mockitodemo.test_doubles.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockTest {
    @Test
    public void demoMock(){
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock() ;
        BookService bookService = new BookService(bookRepositoryMock) ;
       
        Book book1 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        Book book2 = new Book("2", "JUnit5 In Action", 400, LocalDate.now()) ;
        
        bookService.addBook(book1); //return
        bookService.addBook(book2); //save will be called

        bookRepositoryMock.verify(book2, 1) ;
    }

    @Test
    public void demoMockWithMockito(){
        BookRepository bookRepositoryMock = mock(BookRepository.class) ;
        BookService bookService = new BookService(bookRepositoryMock) ;
       
        Book book1 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        Book book2 = new Book("2", "JUnit5 In Action", 400, LocalDate.now()) ;
        
        bookService.addBook(book1); //return
        bookService.addBook(book2); //save will be called

        // verify(bookRepositoryMock).save(book2);
        verify(bookRepositoryMock, Mockito.times(1)).save(book2);
        verify(bookRepositoryMock, Mockito.times(0)).save(book1);
    }
}

package com.kdacademy.junit.mockitodemo.test_doubles.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StubTest {
    
    @Test
    public void demoStub(){
        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository) ;
        List<Book> newBooksWithAppliedDiscount =  bookService.getNewBooksWithAppliedDiscount(10, 7) ; 
        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    public void demoStubWithMockito(){
        
    }
}

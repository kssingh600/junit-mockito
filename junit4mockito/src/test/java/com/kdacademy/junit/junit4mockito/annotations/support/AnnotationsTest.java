package com.kdacademy.junit.junit4mockito.annotations.support;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
// import org.junit.Before;
// import org.mockito.MockitoAnnotations;
// import org.junit.runner.RunWith;
// import org.mockito.junit.MockitoJUnitRunner;

// @RunWith(MockitoJUnitRunner.class) can be replaced with @Before or @Rule
public class AnnotationsTest { 

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule(); //this variable must be declared public

    @InjectMocks
    private BookService bookService ;

    @Mock
    private BookRepository bookRepository ;

    // @Before
    // public void beforeEach(){
    //     MockitoAnnotations.openMocks(this);
    // }

    @Test
    public void demoCreateMocksUsingAnnotations(){
        Book book1 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        Book book2 = new Book("2", "JUnit5 In Action", 400, LocalDate.now()) ;
        List<Book> newBooks = new ArrayList<>() ;
        newBooks.add(book1) ;
        newBooks.add(book2) ;
        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);
        List<Book> newBooksWithAppliedDiscount =  bookService.getNewBooksWithAppliedDiscount(10, 7) ; 
        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}

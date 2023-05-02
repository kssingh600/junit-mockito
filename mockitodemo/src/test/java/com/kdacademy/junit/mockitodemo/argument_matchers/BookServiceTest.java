package com.kdacademy.junit.mockitodemo.argument_matchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    
    @InjectMocks
    private BookService bookService ;

    @Mock
    private BookRepository bookRepository ;

    // @Spy
    // private BookRepository bookRepository ;


    @Test
    public void testUpdatePrice(){
        Book book1 = new Book("1", "Mockito In Action", 600, LocalDate.now()) ;
        Book book2 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        when(bookRepository.findBookByBookId(any(String.class))).thenReturn(book1) ;
        bookService.updatePrice("123", 500);
        verify(bookRepository).save(book2);
    }

    @Test
    public void testInvalidUseOfArgumentMatchers(){
        Book book1 = new Book("1", "Mockito In Action", 600, LocalDate.now()) ;
        //argument matchers should be provided for all arguments
        //argument matchers should not be used outside of stubbing or verification
        when(bookRepository.findBookByTitleAndPublishedDate(eq("Mockito In Action"), any())).thenReturn(book1) ;    
        Book actualBook = bookService.getBookByTitleAndPublishedDate("Mockito In Action", LocalDate.now()); 
        assertEquals("Mockito In Action", actualBook.getTitle());
    }

    @Test
    public void testSpecificTypeOfArgumentMatchers(){
        Book book1 = new Book("1", "Mockito In Action", 600, LocalDate.now()) ;
        //argument matchers should be provided for all arguments
        //argument matchers should not be used outside of stubbing or verification
        // when(bookRepository.findBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true)).thenReturn(book1) ;    
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book1) ;    
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true); 
        assertEquals("Mockito In Action", actualBook.getTitle());
    }

    @Test
    public void testCollectionTypeArgumentMatchers(){
        List<Book> books = new ArrayList<>() ;
        Book book1 = new Book("1", "Mockito In Action", 600, LocalDate.now()) ;
        books.add(book1) ;
        bookService.addBooks(books);
        verify(bookRepository).saveAll(anyList());
    }

    @Test
    public void testStringTypeArgumentMatchers(){
        Book book1 = new Book("1", "Mockito In Action", 600, LocalDate.now()) ;
        // when(bookRepository.findBookByTitleAndPriceAndIsDigital(startsWith("Mockito "), anyInt(), anyBoolean())).thenReturn(book1) ;    
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(contains("Action"), anyInt(), anyBoolean())).thenReturn(book1) ;    
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true); 
        assertEquals("Mockito In Action", actualBook.getTitle());
    }
}

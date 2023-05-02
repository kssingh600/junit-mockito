package com.kdacademy.junit.mockitodemo.bdd.stubbing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.BDDAssertions.*;

@ExtendWith(MockitoExtension.class)
public class StubTest {

    @InjectMocks
    private BookService bookService ;

    @Mock
    private BookRepository bookRepository ;
    
    @Test
    public void testStubbingInTraditionalMockitoStyle(){
        Book book1 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        Book book2 = new Book("2", "Mockito In Action", 400, LocalDate.now()) ;
        List<Book> newBooks = new ArrayList<>() ;
        newBooks.add(book1);
        newBooks.add(book2);
        when(bookRepository.findNewBooks(7)).thenReturn(newBooks) ;
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7) ;
        assertEquals(2, newBooksWithAppliedDiscount.size()) ;
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice()) ;
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice()) ;
    }

    @Test
    @DisplayName("given - New Books, when - Get New Books With Applied Discount Method is Called, Then - New books with applied discount is returned")
    public void test_Given_NewBooks_when_GetNewBooksWithAppliedDiscountIsCalled_Then_NewBooksWithAppliedDiscountIsReturned(){
        //Arrange - Given
        Book book1 = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        Book book2 = new Book("2", "Mockito In Action", 400, LocalDate.now()) ;
        List<Book> newBooks = new ArrayList<>() ;
        newBooks.add(book1);
        newBooks.add(book2);       
        given(bookRepository.findNewBooks(7)).willReturn(newBooks);

        //Act - when
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7) ;

        //Assert - Then
        // assertEquals(2, newBooksWithAppliedDiscount.size()) ;
        // assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice()) ;
        // assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice()) ;
        
        // AssertJ - BDDAssertions
        then(newBooksWithAppliedDiscount).isNotNull() ;
        then(newBooksWithAppliedDiscount.size()).isEqualTo(2) ;
        then(newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450) ;
    }
}

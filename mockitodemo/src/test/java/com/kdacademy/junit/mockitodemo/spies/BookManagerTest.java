package com.kdacademy.junit.mockitodemo.spies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    private BookManager bookManager ;

    @Spy
    private BookService bookService ;

    @Test
    public void testMockitoSpy(){
        // BookService bookService = Mockito.spy(BookService.class) ;
        // BookManager bookManager = new BookManager(bookService) ;
        // we need to mock findBook because it is communicating to database or not implemented
        // we need to call getAppliedDiscount to calculate the discounted price
        Book book = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        doReturn(book).when(bookService).findBook("1") ;
        // when(bookService.findBook("1")).thenReturn(book) ; //avoid using this with spy
        int actualDiscount = bookManager.applyDiscountOnBook("1", 10) ;
        assertEquals(450, actualDiscount);
    }
}

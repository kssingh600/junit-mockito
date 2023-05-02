package com.kdacademy.junit.mockitodemo.bdd.behavior_verification;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    
    @InjectMocks
    private BookService bookService ;

    // @Mock
    // private BookRepository bookRepository ;

    @Spy
    private BookRepository bookRepository ;

    @Test
    public void testUpdatePrice2(){
        Book book = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        when(bookRepository.findBookByBookId("1")).thenReturn(book) ;
        bookService.updatePrice("1", 500) ;
        verify(bookRepository).findBookByBookId("1") ;
        verify(bookRepository).save(book);
        // verifyNoInteractions(bookRepository);
    }

    @Test
    public void test_Given_ABook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated(){
        //Given - Arrange
        Book book = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        given(bookRepository.findBookByBookId("1")).willReturn(book) ;

        //when - Act
        bookService.updatePrice("1", 500);

        //Then - Assert/Verify
        BDDMockito.then(bookRepository).should().save(book);
    }
}

package com.kdacademy.junit.mockitodemo.behavior.verification;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
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
    public void testAddBook(){
        Book book1 = new Book(null, "Mockito In Action", 500, LocalDate.now()) ;
        bookService.addBook(book1);
        //behavior verification
        verify(bookRepository).save(book1);
    }

    @Test
    public void testSaveBookWithBookRequest(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now()) ;
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now()) ;
        bookService.addBook(bookRequest);
        verify(bookRepository, Mockito.times(1)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now()) ;
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now()) ;
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        verify(bookRepository, Mockito.times(2)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice1(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now()) ;
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now()) ;
        bookService.addBook(bookRequest);
        verify(bookRepository, never()).save(book);
    }

    @Test
    public void testUpdatePrice(){
        bookService.updatePrice(null, 600) ;
        verifyNoInteractions(bookRepository);
    }

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
    public void testUpdatePrice3(){
        Book book = new Book("1", "Mockito In Action", 500, LocalDate.now()) ;
        when(bookRepository.findBookByBookId("1")).thenReturn(book) ;
        bookService.updatePrice("1", 500) ;

        InOrder inOrder = Mockito.inOrder(bookRepository) ;
        inOrder.verify(bookRepository).findBookByBookId("1") ;
        inOrder.verify(bookRepository).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice3(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now()) ;
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now()) ;
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        // verify(bookRepository, times(2)).save(book);
        verify(bookRepository, atLeast(2)).save(book);
        verify(bookRepository, atMost(2)).save(book);
        // verify(bookRepository, atMostOnce()).save(book);
        verify(bookRepository, atLeastOnce()).save(book);
    }

}

package com.kdacademy.junit.mockitodemo.spies;

public class BookManager {
    
    private BookService bookService ;

    public BookManager(BookService bookService){
        this.bookService = bookService ;
    }

    public int applyDiscountOnBook(String bookId, int discountRate){
        Book book = bookService.findBook(bookId) ;  //we need to mock
        int discountedPrice = bookService.getAppliedDiscount(book, discountRate) ; //we need to call
        return discountedPrice ;
    }
}

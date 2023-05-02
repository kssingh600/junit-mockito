package com.kdacademy.junit.mockitodemo.spies;

public class BookService {

    public Book findBook(String bookId) {
        // code to bring book from database
        // return null;    //method not implemented
        throw new RuntimeException("Method not implemented") ;
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice() ;
        int newPrice = price - (price * discountRate/100) ;
        return newPrice ;
    }

    
}

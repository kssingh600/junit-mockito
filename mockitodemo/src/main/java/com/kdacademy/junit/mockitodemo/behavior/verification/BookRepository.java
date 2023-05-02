package com.kdacademy.junit.mockitodemo.behavior.verification;

public interface BookRepository {

    void save(Book book) ;

    Book findBookByBookId(String bookId);
    
}

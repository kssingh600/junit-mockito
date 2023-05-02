package com.kdacademy.junit.mockitodemo.bdd.behavior_verification ;

public interface BookRepository {

    void save(Book book) ;

    Book findBookByBookId(String bookId);
    
}

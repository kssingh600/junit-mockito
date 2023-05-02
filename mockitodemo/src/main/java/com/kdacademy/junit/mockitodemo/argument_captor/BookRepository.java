package com.kdacademy.junit.mockitodemo.argument_captor;

public interface BookRepository {

    void save(Book book) ;

    Book findBookByBookId(String bookId);
    
}

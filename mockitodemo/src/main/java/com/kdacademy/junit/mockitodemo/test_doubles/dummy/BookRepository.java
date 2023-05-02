package com.kdacademy.junit.mockitodemo.test_doubles.dummy;

import java.util.Collection;

public interface BookRepository {
    void save(Book book) ;
    Collection<Book> findAll() ;
}

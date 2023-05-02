package com.kdacademy.junit.mockitodemo.bdd.stubbing;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
    
}

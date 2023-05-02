package com.kdacademy.junit.mockitodemo.annotations.support;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
    
}

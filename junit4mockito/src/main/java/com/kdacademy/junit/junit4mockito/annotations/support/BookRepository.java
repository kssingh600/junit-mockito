package com.kdacademy.junit.junit4mockito.annotations.support;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
    
}

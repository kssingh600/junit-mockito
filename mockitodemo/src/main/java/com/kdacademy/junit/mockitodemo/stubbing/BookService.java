package com.kdacademy.junit.mockitodemo.stubbing;

import java.util.List;

public class BookService {
    
    private BookRepository bookRepository ;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
        List<Book> newBooks = bookRepository.findNewBooks(days) ;
        //price: 500 -> apply 10% discount -> 10% of 500 -> 450
        for(Book book: newBooks){
            int price = book.getPrice() ;
            int newPrice = price - (price*discountRate/100) ;
            book.setPrice(newPrice);
        }
        return newBooks ;
    }

    public int calculateTotalCost(List<String> bookIds){
        int total = 0 ;
        for(String bookId: bookIds){
            Book book = bookRepository.findBookByBookId(bookId) ;
            total+=book.getPrice() ;
        }
        return total ;
    }

    public void addBook(Book book){
        bookRepository.save(book) ;
    }

    public void addBook(BookRequest bookRequest){
        Book book = new Book() ;
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book) ;
    }
}

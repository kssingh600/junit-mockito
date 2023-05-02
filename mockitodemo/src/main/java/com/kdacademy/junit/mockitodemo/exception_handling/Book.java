package com.kdacademy.junit.mockitodemo.exception_handling;

import java.time.LocalDate;

public class Book {

    private String bookId ;
    private String title ;
    private int price ;
    private LocalDate publishedDate ;

    public Book() {
    }

    public Book(String bookId, String title, int price, LocalDate publishedDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", publishedDate=" + publishedDate
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + price;
        result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (price != other.price)
            return false;
        if (publishedDate == null) {
            if (other.publishedDate != null)
                return false;
        } else if (!publishedDate.equals(other.publishedDate))
            return false;
        return true;
    }

    
}

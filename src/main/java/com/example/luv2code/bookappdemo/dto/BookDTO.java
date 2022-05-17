package com.example.luv2code.bookappdemo.dto;

public class BookDTO {
    @Override
    public String toString() {
        return "BookDTO{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", genre='" + genre + '\'' +
                '}';
    }

    private int bookId ;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    private String bookName ;
    private int bookPrice ;
    private String genre ;

    public BookDTO()
    {
        //  Default Constructor
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

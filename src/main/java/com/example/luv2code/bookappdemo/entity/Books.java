package com.example.luv2code.bookappdemo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Books
{
    //mapping ,user books
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public int bookId ;

    @NonNull
    @Size(min=1,message="is required")
    @Column(name = "book_name")
    public String bookName;

    @Min(value=1,message ="must be greater than or equal to one")
    @Column(name = "price")
    public int bookPrice ;

   // @NotNull(message="is required")
    @NonNull
    @Size(min=1,message="is required")
    @Column(name = "genre")
    public String genre ; //enum

    public Books(String bookName, int bookPrice, String genre) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.genre = genre;
    }

}
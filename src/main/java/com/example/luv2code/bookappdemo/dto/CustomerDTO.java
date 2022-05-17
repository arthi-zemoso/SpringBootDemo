package com.example.luv2code.bookappdemo.dto;

import java.util.List;

public class CustomerDTO {
    private int id ;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", booksList=" + booksList +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstName ;
    private String lastName ;

    public List<BookDTO> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<BookDTO> booksList) {
        this.booksList = booksList;
    }

    private String email ;
    private List<BookDTO> booksList ;

    public CustomerDTO()
    {
        System.out.println("Default Constructor Called");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


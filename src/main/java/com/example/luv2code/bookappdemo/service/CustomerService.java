package com.example.luv2code.bookappdemo.service;

import com.example.luv2code.bookappdemo.entity.Books;
import com.example.luv2code.bookappdemo.entity.Customers;

import java.util.List;

public interface CustomerService
{
    public List<Customers> findAllCustomer() ;
    public List<Books> findAllBooks() ;
    public Customers findById(int customerId);
    public Books findBookId(int bookId);
    public void addNewCustomer(Customers customers) ;
    public void addnewBooks(Books books) ;
    public void deleteCustomer(int customerId) ;
    public void deleteBook(int bookId) ;
    public Customers saveCustomer(Customers customers , int customerid) ;
    public Books saveBook(Books books,int bookid) ;
    public void saveCustomer(Customers customers) ;
    public void saveBook(Books books) ;
}
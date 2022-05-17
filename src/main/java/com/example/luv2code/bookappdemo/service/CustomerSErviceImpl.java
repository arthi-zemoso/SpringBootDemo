package com.example.luv2code.bookappdemo.service;

import com.example.luv2code.bookappdemo.dao.BooksRepository;
import com.example.luv2code.bookappdemo.dao.CustomerRepository;
import com.example.luv2code.bookappdemo.entity.Books;
import com.example.luv2code.bookappdemo.entity.Customers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerSErviceImpl implements CustomerService
{
   private  CustomerRepository customerRepository;
   private BooksRepository booksRepository;

    public CustomerSErviceImpl(CustomerRepository customerRepository, BooksRepository booksRepository) {
        this.customerRepository = customerRepository;
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Customers> findAllCustomer()
    {
        return customerRepository.findAll() ;
    }

    @Override
    public List<Books> findAllBooks()
    {
        return booksRepository.findAll() ;
    }

    @Override
    public Customers findById(int customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Books findBookId(int bookId) {
        return booksRepository.findById(bookId).get() ;
    }

    @Override
    public void addNewCustomer(Customers customers) {
        customerRepository.save(customers) ;
    }

    @Override
    public void addnewBooks(Books books) {
        booksRepository.save(books);
    }

    @Override
    public void deleteCustomer(int customerId)
    {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void deleteBook(int bookId)
    {
        booksRepository.deleteById(bookId);
    }

    @Override
    public Customers saveCustomer(Customers customers, int customerid) {
        Customers emp = customerRepository.save(customers);
        //get list of employees for that department
        List<Customers> customersList=new ArrayList<>() ;
        if (!customersList.contains(emp)) {
            customersList.add(emp);
        }
        return emp;
    }

    @Override
    public Books saveBook(Books books, int bookid) {
        Books emp = booksRepository.save(books);
        //get list of employees for that department
        List<Books> bookssList=new ArrayList<>() ;
        if (!bookssList.contains(emp)) {
            bookssList.add(emp);
        }
        return emp;
    }

    @Override
    public void saveCustomer(Customers customers)
    {
        customerRepository.save(customers);
    }

    @Override
    public void saveBook(Books books)
    {
        booksRepository.save(books);
    }


}

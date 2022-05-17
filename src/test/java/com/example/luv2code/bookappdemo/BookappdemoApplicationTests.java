package com.example.luv2code.bookappdemo;

import com.example.luv2code.bookappdemo.dao.BooksRepository;
import com.example.luv2code.bookappdemo.dao.CustomerRepository;
import com.example.luv2code.bookappdemo.entity.Books;
import com.example.luv2code.bookappdemo.entity.Customers;
import com.example.luv2code.bookappdemo.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes={com.example.luv2code.bookappdemo.BookappdemoApplication.class})
class BookappdemoApplicationTests {

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private BooksRepository booksRepository;

	@Mock
	private CustomerService customerService;

	@Test
	void find_All_Customers_Test()
	{
		Customers customers = new Customers("Vinay" ,"Singh" , "vinaysingh@gmail.com") ;
		Customers customers2 = new Customers("Ahilya" ,"Singh" ,"ahilya@gmail.com") ;
		Customers customers3 = new Customers("Rajeev" ,"Shukla" ,"rajeev.s@gmail.com") ;
		List<Customers> customersList = new ArrayList<>();
		customersList.add(customers) ;
		customersList.add(customers2) ;
		customersList.add(customers3) ;
		Mockito.when(customerRepository.findAll()).thenReturn(customersList) ;
		Assertions.assertEquals(customersList,customerRepository.findAll());
		verify(customerRepository).findAll() ;
	}
	@Test
	void find_All_Books_Test()
	{
		Books books = new Books("Springboot in Deep",4500,"Backend Development");
		Books books2 = new Books("Django in Deep",5500,"Backend Development");
		Books books3 = new Books("Css in Deep",3300,"Frontend Development");
		List<Books> booksList = new ArrayList<>() ;
		booksList.add(books) ;
		booksList.add(books2) ;
		booksList.add(books3) ;
		Mockito.when(booksRepository.findAll()).thenReturn(booksList) ;
		Assertions.assertEquals(booksList,booksRepository.findAll());
		verify(booksRepository).findAll() ;
	}

	@Test
	void test_Customer_By_Id()
	{
		Customers customers2 = new Customers("arthi" ,"a" , "arthianeel@gmail.com") ;
		int id = 8;
		Mockito.when(customerRepository.findById(id)).thenReturn(Optional.of(customers2)) ;
		Assertions.assertEquals(customers2,customerService.findById(id));
		Mockito.verify(customerRepository).findById(id) ;
	}

	@Test
	void test_Book_By_Id()
	{
		Books books = new Books("love and beyond",400,"romance") ;
		int id = 4;

		//Mockito.when(booksRepository.findById(id).get());
		Mockito.when(booksRepository.findById(id)).thenReturn(Optional.of(books)) ;
		Assertions.assertEquals(books,customerService.findBookId(id));
		Mockito.verify(booksRepository).findById(id) ;
	}

	@Test
	void test_save_Book()
	{
		Books books = new Books("love and beyond",400,"romance") ;
		int id = 4;

		//Mockito.when(booksRepository.findById(id).get());
		customerService.saveBook(books);
		//Assertions.assertEquals(books,booksRepository.save(books));
		verify(booksRepository,Mockito.times(1)).save(books) ;
	}
	@Test
	void test_save_Customer()
	{
		Customers books = new Customers("arthi" ,"a" ,"arthianeel@gmail.com") ;
		int id = 4;
		//Mockito.when(booksRepository.findById(id).get());
		//Mockito.when(customerRepository.save(books)).thenReturn(books);
		//Mockito.verify(customerRepository).save(books) ;
		customerService.saveCustomer(books,id);
		verify(customerRepository,Mockito.times(1)).save(books) ;
		//Assertions.assertEquals(books,customerRepository.save(books));
	//	Mockito.verify(customerRepository).save(books) ;
	}

	@Test
	void deleteConsumerTest(){
		Customers customers2 = new Customers("arthi" ,"a" ,"arthianeel@gmail.com") ;
          int id=8;
		//customerRepository.delete(customers2);
		customerRepository.deleteById(8);
		customerService.deleteCustomer(id);
		verify(customerRepository,times(1)).deleteById(id);
		Books books = new Books("love and beyond",400,"romance") ;
		int bookId = 4;
		booksRepository.deleteById(8);
		customerService.deleteBook(bookId);
		verify(booksRepository,times(1)).deleteById(id);
	}






}


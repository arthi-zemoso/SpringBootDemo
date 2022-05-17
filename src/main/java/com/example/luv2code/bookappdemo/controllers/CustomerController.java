package com.example.luv2code.bookappdemo.controllers;

import com.example.luv2code.bookappdemo.dto.BookDTO;
import com.example.luv2code.bookappdemo.dto.CustomerDTO;
import com.example.luv2code.bookappdemo.entity.Books;
import com.example.luv2code.bookappdemo.entity.Customers;
import com.example.luv2code.bookappdemo.exceptions.DataNotFound;
import com.example.luv2code.bookappdemo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class CustomerController{

    private ModelMapper modelMapper ;
    private CustomerService customerService ;

    private Logger logger =Logger.getLogger(CustomerController.class.getName());
    public CustomerController(CustomerService theCustomerService)
    {
         customerService=theCustomerService;
    }


    @RequestMapping("/")
    public String getHomepage()
    {
        return "homepage" ;
    }

    @GetMapping("/showCustomerList")
    public String customerList(Model model)
    {
        List<Customers> theEmployees=customerService.findAllCustomer();

        // add to the spring model
        model.addAttribute("theCustomerList", theEmployees);

        return "customer-list" ;
    }

    @GetMapping("/showBookList")
    public String bookList(Model model)
    {
      /*  List<BookDTO> bookDtoList =customerService.findAllBooks().stream()
                .map(books -> modelMapper.map(books,BookDTO.class))
                .collect(Collectors.toList());

       */
        List<Books> bookDtoList=customerService.findAllBooks();
        model.addAttribute("theBookList",bookDtoList) ;

        return "book-list";
    }

    @GetMapping("/addCustomerForm")
    public String addCustomerForm(Model model)
    {
        Customers customers = new Customers() ;
        model.addAttribute("customer",customers) ;
        return "customer-register-form.html" ;
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") @Valid Customers customers,Errors errors,Model model)
    { if (null != errors && errors.getErrorCount() > 0) {
        return "customer-register-form";
    } else {
        customerService.saveCustomer(customers);
        return "redirect:/";
    }
    }

    @GetMapping("/addBookForm")
    public String addBookForm(Model model)
    {
        Books books = new Books() ;
        model.addAttribute("book",books) ;
        return "book-register-form" ;
    }

    @PostMapping("/saveBook")
    public String saveCustomer(@ModelAttribute("book") @Valid Books books, Errors errors, Model model)
    {        if (null != errors && errors.getErrorCount() > 0) {
        return "book-register-form";
    } else {
        model.addAttribute("successMsg", "Details saved successfully!!");
        customerService.saveBook(books);
        return "redirect:/" ;
    }
    }

    @GetMapping("/customerDelete")
    public String deleteform(@RequestParam("customerId") int Id)
    {
        Customers customers = customerService.findById(Id) ;
        if(customers == null)
        {
            throw new DataNotFound("No respective is Id there is the DB");
        }
        customerService.deleteCustomer(Id);
        return  "redirect:/" ;
    }

    @GetMapping("/bookDelete")
    public String deleteBookform(@RequestParam("customerId") int Id)
    {
        Books books = customerService.findBookId(Id) ;
        if(books == null)
        {
            throw new RuntimeException("No respective is Id there is the DB");
        }
        customerService.deleteBook(Id);
        return  "redirect:/" ;
    }

    @GetMapping("/customerUpdate")
    public String updateCustomerform(@RequestParam("customerId") int Id , Model model)
    {
        Customers customers = customerService.findById(Id) ;
        if(customers == null)
        {
            throw new RuntimeException("No respective is Id there is the DB");
        }
        model.addAttribute("customer",customers) ;
        return  "customer-register-form.html";
    }

    @GetMapping("/bookUpdate")
    public String updateBookform(@RequestParam("customerId") int Id , Model model)
    {
        Books books = customerService.findBookId(Id) ;
        if(books == null)
        {
            throw new DataNotFound("No respective is Id there is the DB");
        }
        model.addAttribute("book",books) ;
        return  "book-register-form";
    }

}

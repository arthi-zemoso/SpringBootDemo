package com.example.luv2code.bookappdemo.dao;

import com.example.luv2code.bookappdemo.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customers, Integer>  {

}

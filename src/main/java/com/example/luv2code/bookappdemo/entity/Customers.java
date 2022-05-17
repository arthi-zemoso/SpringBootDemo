package com.example.luv2code.bookappdemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id ;
//constraint,validation

    //@NotNull(message="is required")
    @NonNull
    @Size(min=1,message="is required")
    @Column(name = "first_name")
    private String firstName ;

    @NonNull
    @Size(min=1,message="is required")
    @Column(name = "last_name")
    private String lastName ;


    @NonNull
    @Size(min=1,message="is required")
    @Column(name = "email")
    private String email ;

    public Customers(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        this.email = email;
    }


}
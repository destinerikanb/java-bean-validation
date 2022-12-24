package com.destinerikanb.javavalidation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {

    @NotBlank(message = "First name can not blank")
    @Size(max = 20, message = "First name length max 20 characters")
    private String firstName;

    @NotBlank(message = "Last name can not blank")
    @Size(max = 20, message = "Last name length max 20 characters")
    private String lastName;

    @NotNull(message = "Address can not null")
    @Valid
    private Address address;

    //Constructor Validation
    @Valid
    public Person(@NotBlank(message = "first name must not balank") String firstName,
                  @NotBlank(message = "last name must not blank") String lastName,
                  @NotNull(message = "address must not null") Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Valid
    public Person() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "name must not blanlk") String name){
        System.out.println("Hi " + name + ", my name is " + this.firstName);
    }

    @NotBlank(message = "Not blank")
    public String fullName(){
        return firstName + " " + lastName;
    }
}

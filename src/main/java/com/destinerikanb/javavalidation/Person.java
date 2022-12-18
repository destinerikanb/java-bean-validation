package com.destinerikanb.javavalidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person {

    @NotBlank(message = "First name can not blank")
    @Size(max = 20, message = "First name length max 20 characters")
    private String firstName;

    @NotBlank(message = "Last name can not blank")
    @Size(max = 20, message = "Last name length max 20 characters")
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

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
}

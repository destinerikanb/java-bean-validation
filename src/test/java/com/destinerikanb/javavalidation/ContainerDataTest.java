package com.destinerikanb.javavalidation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest{

    @Test
    void testContainerData() {

        Person person = new Person();
        person.setFirstName("Destin");
        person.setLastName("Erika");
        person.setAddress(new Address());
        person.getAddress().setStreet("Jl. Sultan Agung");
        person.getAddress().setCity("Malang");
        person.getAddress().setCountry("Indonesia");
        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("    ");
        person.getHobbies().add("    ");
        person.getHobbies().add("Gaming");

        validate(person);
    }
}

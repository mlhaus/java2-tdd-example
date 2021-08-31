package com.hauschildt.tests;

import com.hauschildt.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getFirstName() {
        assertEquals(Person.DEFAULT_FIRST_NAME, person.getFirstName());
    }

    @Test
    void setFirstName() {
        String newFirstName = "ABC";
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void setLastName() {
        String newLastName = "ABC";
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT_IN_INCHES, person.getHeightInInches());
    }

    @Test
    void setHeightInInches() {
        int newHeightInInches = 100;
        person.setHeightInInches(newHeightInInches);
        assertEquals(newHeightInInches, person.getHeightInInches());
    }

    @Test
    void setHeightInInchesTooSmall() {
        int newHeightInInches = -1;
        person.setHeightInInches(newHeightInInches);
        assertEquals(Person.DEFAULT_HEIGHT_IN_INCHES, person.getHeightInInches());
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_WEIGHT_IN_POUNDS, person.getWeightInPounds(), 0.0001);
    }

    @Test
    void setWeightInPounds() {
        double newWeightInPounds = 100;
        person.setWeightInPounds(newWeightInPounds);
        assertEquals(newWeightInPounds, person.getWeightInPounds());
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DATE_OF_BIRTH, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirth() {
        LocalDate newDateOfBirth = LocalDate.now();
        person.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, person.getDateOfBirth());
    }

    @Test
    void isAlive() {
        assertEquals(Person.DEFAULT_ALIVE, person.isAlive());
    }

    @Test
    void setAlive() {
        boolean newAlive = false;
        person.setAlive(newAlive);
        assertEquals(newAlive, person.isAlive());
    }

    @Test
    void testToString() {
        assertEquals(
                "Person{" +
                        "firstName='" + Person.DEFAULT_FIRST_NAME + '\'' +
                        ", lastName='" + Person.DEFAULT_LAST_NAME + '\'' +
                        ", heightInInches=" + Person.DEFAULT_HEIGHT_IN_INCHES +
                        ", weightInPounds=" + Person.DEFAULT_WEIGHT_IN_POUNDS +
                        ", dateOfBirth=" + Person.DEFAULT_DATE_OF_BIRTH +
                        ", alive=" + Person.DEFAULT_ALIVE +
                        '}',
                person.toString()
        );
    }

    @Test
    void compareTo() {
        fail();
    }
}
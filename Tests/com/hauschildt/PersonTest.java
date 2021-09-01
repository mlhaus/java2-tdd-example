package com.hauschildt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT_IN_INCHES, person.getHeightInInches());
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_WEIGHT_IN_POUNDS, person.getWeightInPounds(), 0.0001);
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DATE_OF_BIRTH, person.getDateOfBirth());
    }

    @Test
    void isAlive() {
        assertEquals(Person.DEFAULT_ALIVE, person.isAlive());
    }

    @Test
    void setFirstName1LetterGood() {
        String newFirstName = "A";
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());
    }

    @Test
    void setFirstName25LettersGood() {
        String newFirstName = "AAAAAAAAAAAAAAAAAAAAAAAAA";
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());
    }

    @Test
    void setLastName1LetterGood() {
        String newLastName = "A";
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());
    }

    @Test
    void setLastName25LettersGood() {
        String newLastName = "AAAAAAAAAAAAAAAAAAAAAAAAA";
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());
    }

    @Test
    void setHeightInInches1Good() {
        int newHeightInInches = 1;
        person.setHeightInInches(newHeightInInches);
        assertEquals(newHeightInInches, person.getHeightInInches());
    }

    @Test
    void setHeightInInches100Good() {
        int newHeightInInches = 100;
        person.setHeightInInches(newHeightInInches);
        assertEquals(newHeightInInches, person.getHeightInInches());
    }

    @Test
    void setWeightInPounds1Good() {
        double newWeightInPounds = 1;
        person.setWeightInPounds(newWeightInPounds);
        assertEquals(newWeightInPounds, person.getWeightInPounds());
    }

    @Test
    void setWeightInPounds1000Good() {
        double newWeightInPounds = 1000;
        person.setWeightInPounds(newWeightInPounds);
        assertEquals(newWeightInPounds, person.getWeightInPounds());
    }

    @Test
    void setDateOfBirthNowGood() {
        LocalDate newDateOfBirth = LocalDate.now();
        person.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirthInThePastGood() {
        LocalDate newDateOfBirth = LocalDate.now().minusDays(1);
        person.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, person.getDateOfBirth());
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
    void compareToLastNameBeforeOther() {
        // person is John Doe
        // otherPerson is John ZZZ
        Person otherPerson = new Person();
        otherPerson.setLastName("ZZZ");
        int result = person.compareTo(otherPerson);
        assertTrue(result < 0);
    }

    @Test
    void compareToLastNameSameFirstNameBeforeOther() {
        // person is John Doe
        // otherPerson is ZZZ Doe
        Person otherPerson = new Person();
        otherPerson.setFirstName("ZZZ");
        int result = person.compareTo(otherPerson);
        assertTrue(result < 0);
    }

    @Test
    void compareToLastNameSameFirstNameSame() {
        // person is John Doe
        // otherPerson is John Doe
        Person otherPerson = new Person();
        int result = person.compareTo(otherPerson);
        assertTrue(result == 0);
    }

    @Test
    void compareToLastNameAfterOther() {
        // person is John Doe
        // otherPerson is John AAA
        Person otherPerson = new Person();
        otherPerson.setLastName("AAA");
        int result = person.compareTo(otherPerson);
        assertTrue(result > 0);
    }

    @Test
    void compareToLastNameSameFirstNameAfterOther() {
        // person is John Doe
        // otherPerson is AAA Doe
        Person otherPerson = new Person();
        otherPerson.setFirstName("AAA");
        int result = person.compareTo(otherPerson);
        assertTrue(result > 0);
    }



    @Test
    void setHeightInInchesBadGreaterThan100() {
        int newHeightInInches = 101;
//        assertThrows(IllegalArgumentException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                person.setHeightInInches(newHeightInInches);
//            }
//        });
        ;
        assertThrows(IllegalArgumentException.class, ()-> {
            person.setHeightInInches(newHeightInInches);
        });
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            person.setHeightInInches(newHeightInInches);
//        });
//
//        String expectedMessage = "The height in inches must be between 0 and 100.";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
    }



}
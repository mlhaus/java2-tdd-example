package com.hauschildt;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private LocalDate dateOfBirth;
    private boolean alive;
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final int DEFAULT_HEIGHT_IN_INCHES = 0;
    public static final double DEFAULT_WEIGHT_IN_POUNDS = 0;
    public static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.now();
    public static final boolean DEFAULT_ALIVE = true;

    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_HEIGHT_IN_INCHES, DEFAULT_WEIGHT_IN_POUNDS, DEFAULT_DATE_OF_BIRTH, DEFAULT_ALIVE);
    }

    public Person(String firstName, String lastName, int heightInInches, double weightInPounds, LocalDate dateOfBirth, boolean alive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.dateOfBirth = dateOfBirth;
        this.alive = alive;
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

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        validateHeightInInches(heightInInches);
        this.heightInInches = heightInInches;
    }

    private void validateHeightInInches(int heightInInches) {
        if (heightInInches < 0 || heightInInches > 100) {
            throw new IllegalArgumentException("The height in inches must be between 0 and 100.");
        }
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", heightInInches=" + heightInInches +
                ", weightInPounds=" + weightInPounds +
                ", dateOfBirth=" + dateOfBirth +
                ", alive=" + alive +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int last_name_comparison = this.lastName.compareToIgnoreCase(o.lastName);
        // If last name's are different, sort by last_name
        if(last_name_comparison != 0) {
            return last_name_comparison;
        }
        // If last name's are the same, sort by first_name
        return this.firstName.compareToIgnoreCase(o.firstName);
    }
}

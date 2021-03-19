/*
Author: James Leandri
E-mail: jdleandri3@gmail.com
Company: Diamond Kinetics
Assignment: Coding Challenge
Last Updated: 3/19/2021
File: Main.java
Purpose: Java application that implements a Tuple class
Compiler/IDE: Java SE Development Kit 11.0.5/IntelliJ IDE 2019.3.2
Operating system: macOS Big Sur
Reference(s): Java 10 API - Oracle Documentation
              (https://docs.oracle.com/javase/10/docs/api/)
*/
package com.company;

// Data type Tuple to return multiple values in searchMultiContinuityWithinRange
public class Tuple<X, Y> {

    // Stores two values of unknown types
    public final X x;
    public final Y y;

    /** This method constructs a Tuple given the two parameters
    *
    * @param x First value of unknown type to store
    * @param y Second value of unknown type to store */
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")" ;
    }

}

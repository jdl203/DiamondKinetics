/*
Author: James Leandri
E-mail: jdleandri3@gmail.com
Company: Diamond Kinetics
Assignment: Coding Challenge
Last Updated: 3/19/2021
File: Main.java
Purpose: Java application that implements the DataSample class and supporting methods
Compiler/IDE: Java SE Development Kit 11.0.5/IntelliJ IDE 2019.3.2
Operating system: macOS Big Sur
Reference(s): Java 10 API - Oracle Documentation
              (https://docs.oracle.com/javase/10/docs/api/)
*/

package com.company;

// Data type DataSample to store the values from each time sample from the csv file
public class DataSample {

    // Values from CSV sample Swing Data
    private int timeStamp;
    private float ax;
    private float ay;
    private float az;
    private float wx;
    private float wy;
    private float wz;

    /** This method constructs the DataSample given the 7 parameters
     *
     * @param timeStamp The timeStamp val int assigned to this data sample
     * @param ax The accelerator x val float assigned to this data sample
     * @param ay The accelerator y val float assigned to this data sample
     * @param az The accelerator z val float assigned to this data sample
     * @param wx The gyroscope x val float assigned to this data sample
     * @param wy The gyroscope y val assigned to this data sample
     * @param wz The gyroscope z val assigned to this data sample */
    public DataSample (int timeStamp, float ax, float ay, float az, float wx, float wy, float wz) {
        this.timeStamp = timeStamp;
        this.ax = ax;
        this.ay = ay;
        this.az = az;
        this.wx = wx;
        this.wy = wy;
        this.wz = wz;
    }

    /** This method returns the instance variable timeStamp
     * @return int value of instance variable timeStamp
     */
    public int getTimeStamp() { return this.timeStamp; }

    /** This method returns the instance variable ax
     * @return float value of instance variable ax
     */
    public float getAx() { return this.ax; }

    /** This method returns the instance variable ay
     * @return float value of instance variable ay
     */
    public float getAy() { return this.ay; }

    /** This method returns the instance variable az
     * @return float value of instance variable az
     */
    public float getAz() { return this.az; }

    /** This method returns the instance variable wx
     * @return float value of instance variable wx
     */
    public float getWx() { return this.wx; }

    /** This method returns the instance variable wy
     * @return float value of instance variable wy
     */
    public float getWy() { return this.wy; }

    /** This method returns the instance variable wz
     * @return float value of instance variable wz
     */
    public float getWz() { return this.wz; }

    /** This method overrides the toString method
     * @return String formatted version of the item, used in the cart and displaying which items
     */
    @Override
    public String toString() {
        return "\nTime Stamp:       " + this.timeStamp +
                "\nAccelerometer Vals: " + this.ax + ", " + this.ay + ", " + this.az +
                "\nGyroscope Vals:   " + this.wx + ", " + this.wy + ", " + this.wz;
    }
}

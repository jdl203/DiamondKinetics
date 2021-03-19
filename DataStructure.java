/*
Author: James Leandri
E-mail: jdleandri3@gmail.com
Company: Diamond Kinetics
Assignment: Coding Challenge
Last Updated: 3/19/2021
File: DataStructure.java
Purpose: Java application that implements the dataStructure class
Compiler/IDE: Java SE Development Kit 11.0.5/IntelliJ IDE 2019.3.2
Operating system: macOS Big Sur
Reference(s): Java 10 API - Oracle Documentation
              (https://docs.oracle.com/javase/10/docs/api/)
*/

package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Data type DataStructure to hold all DataSample types in a list and store individual lists of each column from the csv file
public class DataStructure {

    // data will hold all type DataSample in one list
    public List<DataSample> data = new ArrayList<>();
    // Values to store individual arrays for each value of the data structure
    public List<Float> ax, ay, az, wx, wy, wz;

    // Stores the fileName of the data structure
    private String fileName;

    /** Constructor for DataStructure given the parameter
     * Will take in the fileName and create and store DataSamples in list
     * @param fileName String for fileName to create instance of a DataStructure
     */
    public DataStructure(String fileName) {

        // Stores the file name of the data structure
        this.fileName = fileName;

        // creating scanner used to read file
        Scanner inputStream = null;

        // Try-Catch to handle file not found error
        try {
            inputStream = new Scanner(new FileInputStream(fileName));
            System.out.println("File found!");
        }
        // Error handling for missing file
        catch (FileNotFoundException e) {
            System.out.println("File was not found!");
            System.exit(0);
        }

        // Calls the method valuesFromLine for each line in the csv
        while(inputStream.hasNextLine()) {
            // Adds each instance of a DataSample to the data list for this object
            this.data.add(valuesFromLine(inputStream.nextLine()));
        }

        // Stores each column individually for ease of use in main function
        this.ax = dataSet(this.data, "ax");
        this.ay = dataSet(this.data, "ay");
        this.az = dataSet(this.data, "az");
        this.wx = dataSet(this.data, "wx");
        this.wy = dataSet(this.data, "wy");
        this.wz = dataSet(this.data, "wz");

    }

    /** This method returns an instance of type DataSample
     * Takes each value from single line of csv and creates the DataSample
     * @return type DataSample with assigned attributes
     */
    private DataSample valuesFromLine(String line) {

        // Temp vals to store the data parsed from each line in CSV
        int tempTimeStamp;
        float tempAx;
        float tempAy;
        float tempAz;
        float tempWx;
        float tempWy;
        float tempWz;

        // Parses each value in the csv line
        try (Scanner rowStream = new Scanner(line)) {
            rowStream.useDelimiter(",");
            tempTimeStamp = rowStream.nextInt();
            tempAx = rowStream.nextFloat();
            tempAy = rowStream.nextFloat();
            tempAz = rowStream.nextFloat();
            tempWx = rowStream.nextFloat();
            tempWy = rowStream.nextFloat();
            tempWz = rowStream.nextFloat();
        }

        // Returns the object DataSample with the values from the current csv line
        return new DataSample(tempTimeStamp, tempAx, tempAy, tempAz, tempWx, tempWy, tempWz);
    }

    /** This method returns an array of a specified dataset from a list of DataSample's
     * @return List<Float> List of floats of single dataset
     */
    private List<Float> dataSet(List<DataSample> data, String mode) {

        // List to store the values of one column
        List<Float> tempDataSet = new ArrayList<>();

        // Case structure to populate the temp list
        for (DataSample datum : data) {
            switch (mode) {
                case "ax":
                    tempDataSet.add(datum.getAx());
                    break;
                case "ay":
                    tempDataSet.add(datum.getAy());
                    break;
                case "az":
                    tempDataSet.add(datum.getAz());
                    break;
                case "wx":
                    tempDataSet.add(datum.getWx());
                    break;
                case "wy":
                    tempDataSet.add(datum.getWy());
                    break;
                case "wz":
                    tempDataSet.add(datum.getWz());
                    break;
            }
        }

        // Returns the list of one column from data structure
        return tempDataSet;
    }
}

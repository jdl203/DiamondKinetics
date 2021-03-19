/*
Author: James Leandri
E-mail: jdleandri3@gmail.com
Company: Diamond Kinetics
Assignment: Coding Challenge
Last Updated: 3/19/2021
File: Main.java
Purpose: Java application that runs and performs analysis on swing data
Compiler/IDE: Java SE Development Kit 11.0.5/IntelliJ IDE 2019.3.2
Operating system: macOS Big Sur
Reference(s): Java 10 API - Oracle Documentation
              (https://docs.oracle.com/javase/10/docs/api/)
*/

package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /** From indexBegin to indexEnd, search data for values that are higher than threshold
     * @param data List<Float> Data to be searched
     * @param indexBegin int first index to start searching on
     * @param indexEnd int last index to start searching on, inclusive
     * @param threshold float value to trigger the winLength
     * @param winLength int goal for index in a row to satisfy threshold
     * @return Return the first index where data has values that meet this criteria for at least
     * winLength samples in a row
     */
    public static int searchContinuityAboveValue(List<Float> data, int indexBegin, int indexEnd, float threshold, int winLength) {

        // Variables to store conditionals and step
        int currentIndex = indexBegin;
        int currentWinLength = 0;
        boolean winLengthMet = false;

        // Loop through values until winLengthMet true or until list searched reaches indexEnd
        while (!winLengthMet && currentIndex <= indexEnd) {
            // Checks if current value is above the threshold
            if (data.get(currentIndex) > threshold) {
                // Increase the currentWinLength by one
                currentWinLength ++;
            }
            // Resets currentWinLength as current value was not above threshold
            else {
                currentWinLength = 0;
            }

            // Checks if currentWinLength has streak of winLength
            if (currentWinLength >= winLength) {
                winLengthMet = true;
            }
            // Increases step
            currentIndex++;
        }

        // Returns the starting index of threshold streak
        if (winLengthMet) {
            return currentIndex - winLength;
        }

        // Returns -1 if no value was found
        return -1;
    }

    /** From indexBegin to indexEnd (where indexBegin is larger than indexEnd), search data for values that are higher than
     * thresholdLo and lower than thresholdHi
     * @param data List<Float> Data to be searched
     * @param indexBegin int first index to start searching on
     * @param indexEnd int last index to start searching on, inclusive
     * @param thresholdLo float value to trigger the winLength, bottom range
     * @param thresholdHi float value to trigger the winLength, top range
     * @param winLength int goal for index in a row to satisfy threshold
     * @return Return the first index where data has values that
     * meet this criteria for at least winLength samples in a row
     */
    public static int backSearchContinuity(List<Float> data, int indexBegin, int indexEnd, float thresholdLo, float thresholdHi, int winLength) {

        // Variables to store conditionals and step
        int currentIndex = indexBegin;
        int currentWinLength = 0;
        boolean winLengthMet = false;

        // Loop through values until winLengthMet true or until list searched reaches indexEnd
        while (!winLengthMet && currentIndex >= indexEnd) {
            // Checks if current value is above the thresholdLo and below the thresholdHi
            if (data.get(currentIndex) > thresholdLo && data.get(currentIndex) < thresholdHi) {
                // Increase the currentWinLength by one
                currentWinLength ++;
            }
            // Resets currentWinLength as current value was not above threshold
            else {
                currentWinLength = 0;
            }
            // Checks if the winLength was met
            if (currentWinLength >= winLength) {
                winLengthMet = true;
            }
            // Decreases step
            currentIndex--;
        }

        // Returns the index of the start of the wiLength
        if (winLengthMet) {
            return currentIndex + winLength;
        }

        // Returns -1 if no value was found
        return -1;
    }

    /** From indexBegin to indexEnd, search data1 for values that are higher than threshold1 and also search data2 for values
     * that are higher than threshold2
     * @param data1 List<Float> First data to be searched
     * @param data2 List<Float> Second data to be searched
     * @param indexBegin int first index to start searching on
     * @param indexEnd int last index to start searching on, inclusive
     * @param threshold1 float value to trigger the winLength on data1
     * @param threshold2 float value to trigger the winLength on data2
     * @param winLength int goal for index in a row to satisfy threshold
     * @return Return the first index where both data1 and data2 have
     * values that meet these criteria for at least winLength samples in a row
     */
    public static int searchContinuityAboveValueTwoSignals(List<Float> data1, List<Float> data2, int indexBegin, int indexEnd,
                                                           float threshold1, float threshold2, int winLength) {

        // Variables to store conditionals and step
        int currentIndex = indexBegin;
        int currentWinLength = 0;
        boolean winLengthMet = false;

        // Loop through values until winLengthMet true or until list searched reaches indexEnd
        while (!winLengthMet && currentIndex <= indexEnd) {
            // Checks if both values at the current index is above the thresholds respectively
            if (data1.get(currentIndex) > threshold1 && data2.get(currentIndex) > threshold2) {
                // Increase the currentWinLength by one
                currentWinLength ++;
            }
            // Resets currentWinLength as current value was not above threshold
            else {
                currentWinLength = 0;
            }

            // Checks if the winLength was met
            if (currentWinLength >= winLength) {
                winLengthMet = true;
            }
            // Updates step
            currentIndex++;
        }

        // Returns the index of the start of the wiLength
        if (winLengthMet) {
            return currentIndex - winLength;
        }

        // Returns -1 if no value was found
        return -1;
    }

    /** From indexBegin to indexEnd, search data for values that are higher than thresholdLo and lower than thresholdHi
     * @param data List<Float> Data to be searched
     * @param indexBegin int first index to start searching on
     * @param indexEnd int last index to start searching on, inclusive
     * @param thresholdLo float value to trigger the winLength, bottom range
     * @param thresholdHi float value to trigger the winLength, top range
     * @param winLength int goal for index in a row to satisfy threshold
     * @return Return the the starting index and ending index of all continuous samples that meet this criteria for at
     * least winLength data points
     */
    public static List<Tuple> searchMultiContinuityWithinRange(List<Float> data, int indexBegin, int indexEnd, float thresholdLo,
                                                             float thresholdHi, int winLength) {

        // Creates temporary list of data type Tuple to store the pairs of indexes
        List<Tuple> testList = new ArrayList<>();

        // Variables to store conditionals and step
        int startWinIndex = 0;
        int currentIndex = indexBegin;
        int currentWinLength = 0;
        boolean prevIndexWin = true;

        // Loop through all values in the index range
        while (currentIndex <= indexEnd) {
            // Checks if the current value is above and below both threshold values
            if (data.get(currentIndex) > thresholdLo && data.get(currentIndex) < thresholdHi) {
                // Increases the current win length
                currentWinLength++;
                // Checks if this is the first index in a row meeting threshold requirements
                if (!prevIndexWin) {
                    startWinIndex = currentIndex;
                }
                // Stores bool stating this index was a win
                prevIndexWin = true;
            }
            // If the current value did not meet the thresholds
            else {
                // Checks if this current value is the end of a streak
                if (currentWinLength >= winLength && (prevIndexWin || currentIndex == indexEnd)) {
                    Tuple test = new Tuple(startWinIndex, currentIndex - 1);

                    // Adds tuple to the temp list
                    testList.add(test);
                }
                // Resets current win length
                else {
                    currentWinLength = 0;
                }
                // Sets prev as a no hit
                prevIndexWin = false;
            }
            // Increases step
            currentIndex++;
        }

        // Returns the list of tuples with indexes
        return testList;
    }


    public static void main(String[] args) {

        DataStructure data = new DataStructure("latestSwing.csv");

        System.out.println(searchContinuityAboveValue(data.ax, 0, data.ax.size()-1, 0f, 5));
        System.out.println(backSearchContinuity(data.ax, data.ax.size()-1, 0, 0f, 1f, 10));
        System.out.println(searchContinuityAboveValueTwoSignals(data.ax, data.ay, 0, data.ax.size()-1, 0f, 0f, 5));
        System.out.println(searchMultiContinuityWithinRange(data.ax, 0, data.ax.size()-1, 0f, 2f, 5));
    }
}

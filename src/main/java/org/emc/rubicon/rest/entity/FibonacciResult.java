package org.emc.rubicon.rest.entity;

import java.util.Arrays;

/**
 *Created 3/15/2018
 */
public class FibonacciResult {
    String number;
    String[] array;

    public FibonacciResult() {
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FibonacciResult{" +
                "number='" + number + '\'' +
                ", array=" + Arrays.toString(array) +
                "}\n";
    }
}

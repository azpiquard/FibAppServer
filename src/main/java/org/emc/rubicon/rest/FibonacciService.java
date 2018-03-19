package org.emc.rubicon.rest;

/**
 * Function for Leonardo Pisano Bigolio Function test Algorithm on 3/15/2018
 */

import org.springframework.stereotype.Component;
import org.emc.rubicon.rest.entity.FibonacciResult;

@Component
public class FibonacciService {

    FibonacciResult fibonacci(int n) {
        if ( n <= 0) {
            throw new IllegalArgumentException( "Angel greets! Scusami! You have entered a sbagliato bad input : " + n);
        }
        int[] arr = new int[n];
        if (n > 1) {
            arr[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = Integer.toString(arr[i]);
        }
        FibonacciResult result = new FibonacciResult();
        result.setNumber(Integer.toString(n));
        result.setArray(ans);
        return result;
    }
}

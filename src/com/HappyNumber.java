package com;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class HappyNumber {
    int[][] dir = new int[2][2];
    public static boolean isHappy(int n) {
        HashSet<Integer> map = new HashSet<>();
        int sum = 0;
        while(true){
            if(map.contains(n)){
                return false;
            }
            if(sum == 0) map.add(n);
            int remainder = n%10;
            n = n/10;
            sum += (remainder*remainder);
            if(n == 0){
                n = sum;
                sum = 0;
                if(n == 1)  return true;

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));

        // Creating empty priority queue
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());

    }
}

package com.java8.lambdas;

import java.util.Arrays;

/**
 * Created by georgekankava on 28.07.17.
 */
public class ArrayExample {

    int array [] = new int [] {1,2,3,4,5,6,7};

    public void removeArrayIndex(int index) {
        System.out.println("Deleting element at [" + index + "]");
        int [] arrTemp = new int [array.length - 1];
        int i =0;
        int k = 0;
        while(i < arrTemp.length) {
            if (i == index) {
                k++;
            }
            arrTemp[i++] = array[k++];
        }
        array = arrTemp;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        System.out.println(Arrays.toString(arrayExample.array));
        arrayExample.removeArrayIndex(1);
        System.out.println(Arrays.toString(arrayExample.array));
    }
}

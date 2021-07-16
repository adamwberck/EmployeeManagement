package com.cognixia.jump.corejava.arrays;
import java.util.Arrays;

public class ArrayComparison {

    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 5};
        int[] array2 = {2, 1, 5, 3};
        int[] array3 = {1, 3, 5};
        int[] array4 = {1, 2, 7, 5};
        System.out.println(compareArrayNoOrder(array1, array2)) ; // should return true
        System.out.println(compareArrayNoOrder(array1, array3)) ; // should return false because size
        System.out.println(compareArrayNoOrder(array1, array4)) ; // should return false because not the same
    }

    //sort the array and then compare
    public static boolean compareArrayNoOrder(int[] array1, int[] array2){
        if (array1.length != array2.length) {
            return false;
        }
        //clone to avoid manipulating array
        int[] a1 = array1.clone();
        Arrays.sort(a1);
        int[] a2 = array2.clone();
        Arrays.sort(a2);
        return Arrays.equals(a1,a2);
    }
}
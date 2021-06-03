package com.company;
/**
 * created by: Ahmed El said
 * 15.04.2021
 **/

import java.util.Scanner;

public class Merge_Sort_Main_Method {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String User_String = input.nextLine();
        String[] String_Array = User_String.split(" ");
        int[] intArray = new int[String_Array.length];
        for (int i = 0; i < String_Array.length ; i++) {
            intArray[i] = Integer.parseInt(String_Array[i]);
        }
        // 20 35 -15 7 55 1 -22
        mergeSort(intArray, 0, intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }
    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}

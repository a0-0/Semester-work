package com.company;
public class Merge_Sort_Time_Size {
    /**
     * created by: Ahmed El said
     * 15.04.2021
     **/

    private static int numberOfLoops = 0;

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String User_String = input.nextLine();
//        String[] String_Array = User_String.split(" ");
//        int[] intArray = new int[String_Array.length];
//        for (int i = 0; i < String_A      rray.length ; i++) {
//            intArray[i] = Integer.parseInt(String_Array[i]);
//        }
//        // 20 35 -15 7 55 1 -22
//        mergeSort(intArray, 0, intArray.length);
//        for (int i = 0; i < intArray.length; i++) {
//            System.out.print(intArray[i] + " ");
//        }
        // getRandomNumber( from , to )

        // get number of matrices ( Random )
        int numberTheMatrices = getRandomNumber(1,1000);

        for (int i = 0; i < numberTheMatrices; i++) {
            // get number of size for each matrix
            // read from file
            int[] arr = readTheMatrix(100);
            // get time for start
            long startTime = System.nanoTime();
            // Function Call for sort
            mergeSort(arr, 0, arr.length);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println("");
            // get the difference between time
            long estimatedTime = System.nanoTime() - startTime;
            // print all info
            System.out.println("size" + (i + 1) + " = " + arr.length);
            System.out.println("time " + (i + 1) + " = " + estimatedTime);

            numberOfLoops = 0;
        }
    }

    private static int getRandomNumber(int from, int to) {
        int randomNum = (int) (Math.random() * to);
        while (randomNum < from || randomNum > to) {
            randomNum = (int) (Math.random() * to);
        }
        return randomNum;

    }

    public static int[] readTheMatrix(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            int randomNum = (int) (Math.random() * 100);
            numbers[i] = randomNum;
        }
        return numbers;
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

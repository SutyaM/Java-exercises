package hu.prime;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};

        findLongestPeak(arr);
    }

    public static void findLongestPeak(int[] array) {
        //Length of increasing sub-arrays
        int[] increasing = new int[array.length];
        increasing[0] = 1;
        for (int i = 1; i < array.length; i++) {
            increasing[i] = 1;
            if (array[i - 1] < array[i]) {
                increasing[i] = increasing[i - 1] + 1;
            }
        }
        //Length of decreasing sub-arrays
        int[] decreasing = new int[array.length];
        decreasing[array.length - 1] = 1;
        for (int i = array.length - 2; i >= 0; i--) {
            decreasing[i] = 1;
            if (array[i] > array[i+1]) {
                decreasing[i] = decreasing[i + 1] + 1;
            }
        }
        int peakLength = 1;
        int start = 0;
        int end = 0;
        //Find length, start index and end index of "peak"
        for (int i = 0; i < array.length; i++) {
            int id = increasing[i] + decreasing[i] - 1;
            if (peakLength < id) {
                peakLength = id;
                start = i - increasing[i] + 1;
                end = i + decreasing[i] - 1;
            }
        }
        System.out.println("\nLength of peak: " + peakLength);
        System.out.print("\nThe longest peak: ");
        for (int i = start; i <= end; i++) {
            System.out.print(array[i]+" ");
        }
    }
}

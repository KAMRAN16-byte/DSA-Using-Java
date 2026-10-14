package SortingAlgorithms;

import java.util.Arrays;

import static SortingAlgorithms.QuickSort.quickSort;

public class Main
{

    public static void main(String[] args)
    {
        int[] arr = {9,45,6,3,7,1,5};

        quickSort(arr,0,arr.length-1);

        Arrays.stream(arr).mapToObj(n-> n + " ").forEach(System.out::print);
    }

}

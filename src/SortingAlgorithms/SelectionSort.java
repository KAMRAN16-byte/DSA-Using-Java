package SortingAlgorithms;


import java.util.Arrays;

public class SelectionSort
{

    public static void selectionSort(int[] arr)
    {
        for(int i = 0;i < arr.length - 1 ;i++)
        {
            for (int j = i+1;j < arr.length;j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }

    public static void main(String[] args)
    {
        int[] arr = {45,34,7,3,87,2,8,3};
        selectionSort(arr);
        Arrays.stream(arr).mapToObj(n->n + " ").forEach(System.out::print);
    }
}

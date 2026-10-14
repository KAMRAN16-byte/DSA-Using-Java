package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort
{
    public static void mergesort(int[] arr, int start, int end)
    {
        if (start == end)
            return;

        int mid = (start + end) / 2;

        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end)
        {
            if (arr[i] < arr[j])
            {
                temp[k++] = arr[i++];
            } else
            {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid)
        {
            temp[k++] = arr[i++];
        }
        while(j <= end)
        {
            temp[k++] = arr[j++];
        }

        for(int l = start; l <= end; l++)
        {
            arr[l] = temp[l-start];
        }
    }

    public static void mergesortV2(int[] arr ,int start, int end)
    {
        if(start == end)
        {
            return;
        }
        int mid = (start + end) / 2;
        mergesortV2(arr,start,mid);
        mergesortV2(arr,mid+1,end);

        merger(arr,start,end);
    }

    public static void merger(int[] arr, int start, int end)
    {
        int mid = (start + end) / 2;
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end)
        {
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= end)
            temp[k++] = arr[j++];

        for(int l = start; l <= end; l++)
            arr[l] = temp[l-start];

    }

    public static void main(String[] args)
    {


    }
}

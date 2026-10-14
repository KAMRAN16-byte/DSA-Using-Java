package SortingAlgorithms;



public class QuickSort
{

    public static int[] swap(int[] arr)
    {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        return arr;
    }
    public static int quickPivot(int[] arr, int start, int end)
    {
        int pivot = arr[start];
        int j = start;
        for (int i = start + 1; i <= end; i++)
        {
            if (arr[i] < pivot)
            {
                int[] temp = swap(new int[]{arr[i],arr[++j]});
                arr[i] = temp[0];
                arr[j] = temp[1];
//                int temp = arr[++j];
//                arr[j] = arr[i];
//                arr[i] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[start];
        arr[start] = temp;
        return j;
    }

    public static void quickSort(int[] arr, int start, int end)
    {
        if(start >= end)
            return;

        int pivot = quickPivot(arr, start, end);

        quickSort(arr,start,pivot -1 );
        quickSort(arr,pivot + 1,end);
    }
}

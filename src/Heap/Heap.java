package Heap;


public class Heap
{
    private int[] heap;
    private int length, SIZE;

    Heap(int size)
    {
        length = size;
        heap = new int[length + 1];
        SIZE = 0;
    }

    void add(int value)
    {
        heap[SIZE++] = value;
        int child_inx = SIZE - 1;
        for (int parent = ((child_inx - 1) / 2); parent >= 0; parent = parent / 2)
        {
            if (heap[child_inx] > heap[parent])
            {
                int temp = heap[child_inx];
                heap[child_inx] = heap[parent];
                heap[parent] = temp;
                child_inx = parent;
            } else
                break;
        }
    }

    int delete()
    {
        int toReturn = heap[0];
        heap[0] = heap[--SIZE];
        int root = 0;
        while ((root + 1) * 2 - 1 < SIZE)
        {
            int child_inx = (root + 1) * 2 - 1;
            if(child_inx + 1 < SIZE && heap[child_inx + 1] > heap[child_inx])
            {
                child_inx = child_inx + 1;
            }
            if(heap[child_inx] > heap[root])
            {
                int temp = heap[child_inx];
                heap[child_inx] = heap[root];
                heap[root] = temp;
                root = child_inx;
            }
            else
                return toReturn;
        }
        return toReturn;
    }

    int peek()
    {
        return heap[0];
    }

    void display()
    {
        int length = SIZE;
        for (int i = 0; i < length; i++)
        {
            System.out.print(delete() + " ");
        }
    }

    boolean isEmpty()
    {
        return SIZE == 0;
    }

    boolean isFull()
    {
        return SIZE == length;
    }

}

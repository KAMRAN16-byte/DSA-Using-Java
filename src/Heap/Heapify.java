package Heap;

public class Heapify
{
    int[] heap;
    int SIZE;
    int length;

    Heapify(int size)
    {
        this.length = size;
        heap = new int[length];
        SIZE = 0;
    }

    void add(int key)
    {
        heap[SIZE++] = key;
        for (int parent = (SIZE  - 1)  / 2 ; parent > 0; parent = parent / 2 )
        {
            if (parent * 2 + 2 < SIZE && heap[parent * 2 + 2] > heap[parent])
            {
                int temp = heap[parent];
                heap[parent] = heap[parent*2 + 2];
                heap[parent*2 + 2] = temp;
            }
            else if (parent * 2 + 1 < SIZE && heap[parent * 2 + 1] > heap[parent])
            {
                int temp = heap[parent];
                heap[parent] = heap[parent*2 + 1];
                heap[parent*2 + 1] = temp;
            }

        }
    }

    void display()
    {
        for (int i = 0; i < SIZE; i++)
        {
            System.out.print(heap[i] + " ");
        }
    }
}

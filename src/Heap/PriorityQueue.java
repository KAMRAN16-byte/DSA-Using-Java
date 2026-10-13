package Heap;

import java.util.NoSuchElementException;

public class PriorityQueue
{
    Heap heap;
    int SIZE;

    PriorityQueue(int SIZE)
    {
        heap = new Heap(SIZE);
        this.SIZE = 0;
    }

    void offer(int value)
    {
        if(heap.isFull())
            throw new RuntimeException();
        heap.add(value);
    }

    int poll()
    {
        if(heap.isEmpty())
            throw new RuntimeException();
        return heap.delete();
    }

    int peek()
    {
        if(heap.isEmpty())
            throw new RuntimeException();
        return heap.peek();
    }

    void pollAll()
    {
        heap.display();
    }
}

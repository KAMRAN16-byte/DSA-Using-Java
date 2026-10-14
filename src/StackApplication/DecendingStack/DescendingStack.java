package StackApplication.DecendingStack;

import java.util.NoSuchElementException;

public class DescendingStack
{
    int[] stack;
    int SIZE;
    int top;

    public DescendingStack(int size)
    {
        stack = new int[size];
        SIZE = size;
        top = SIZE;
    }

    public boolean isEmpty()
    {
        return top == SIZE;
    }

    public boolean isFull()
    {
        return top == 0;
    }

    public int peek()
    {
        if(isEmpty())
            throw new NoSuchElementException("Stack is empty");
        return stack[top];
    }

    public void add(int data)
    {
        if(isFull())
            throw new RuntimeException("Stack is full");
        stack[--top] = data;
    }

    public int pop()
    {
        if(isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack[top++];
    }
}

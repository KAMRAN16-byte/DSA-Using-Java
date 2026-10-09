package QueueApplication;

import java.util.Scanner;

public class QueueUsingCounter<T>
{
    T[] Queue;
    int front,rear,size, counter;

    @SuppressWarnings("unchecked")
    public QueueUsingCounter(int size)
    {
        this.size = size;
        Queue = (T[]) new Object[size];
        this.front = this.rear =  -1;
        this.counter = 0;
    }

    boolean isEmpty()
    {
        return counter == 0;
    }

    boolean isFull()
    {
        return counter == size;
    }

    void enQueue(T item){
        if(isFull()){
            throw new RuntimeException("Queue is Full");
        }
        counter++;
        if(this.rear == -1){
            this.front = this.rear = 0;
            Queue[this.rear] = item;
            return;
        }
        rear = (rear + 1)%this.size;
        Queue[rear] = item;
    }

    T deQueue()
    {
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        counter--;
        T var = Queue[this.front];
        if(this.front == this.rear){
            this.front = this.rear = -1;
            return var;
        }
        this.front = (front + 1)%this.size;
        return var;
    }

    T peek()
    {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return Queue[this.front];
    }

    static Scanner input = new Scanner(System.in);
    int menu(){
        System.out.println("Menu\n1. Add\n2. Remove\n3 Peek\n0. Exit");
        return input.nextInt();
    }

    public static void main(String[] args)
    {
        QueueUsingCounter<Integer> queue = new QueueUsingCounter<>(5);
        int choice = 0;
        while((choice = queue.menu()) != 0){
            try{
                switch(choice){
                    case 1:{
                        System.out.println("Enter element to add: ");
                        queue.enQueue(input.nextInt());
                        break;
                    }
                    case 2:{
                        System.out.println("Element removed remove: " + queue.deQueue());
                        break;
                    }
                    case 3:{
                        System.out.println("Element peek: " + queue.peek());
                        break;
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

}

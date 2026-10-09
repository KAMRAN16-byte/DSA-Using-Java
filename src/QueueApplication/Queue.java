package QueueApplication;

import java.util.Scanner;

public class Queue<T>
{
    T[] Queue;
    int size,front,rear;

    @SuppressWarnings("unchecked")
    Queue(int size){
        this.size = size;
        this.Queue = (T[]) new Object[size];
        this.front = this.rear = -1;
    }

    boolean isEmpty()
    {
        return this.front == -1;
    }

    boolean isFull()
    {
        return (this.rear + 1) % this.size == this.front;
    }

    void enqueue(T data){
            if(isFull()){
                throw new RuntimeException("Queue is full");
            }
            if(isEmpty()){
                this.front =  this.rear = 0;
                Queue[this.rear] = data;
                return;
            }
            rear = (rear + 1)%this.size;
            Queue[rear] = data;
    }

    T dequeue()
    {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T var = Queue[front];
        if(front == rear){
            front = rear  = -1;
            return var;
        }
        front  = (front + 1)%this.size;
        return var;
    }
    T peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return Queue[front];
    }
    static Scanner input = new Scanner(System.in);
    int menu(){
        System.out.println("Menu\n1. Add\n2. Remove\n3 Peek\n0. Exit");
        return input.nextInt();
    }

    public static void main(String[] args)
    {

        Queue<Integer> queue = new Queue<>(5);
        int choice = 0;
        while((choice = queue.menu()) != 0){
            try{
                switch(choice){
                    case 1:{
                        System.out.println("Enter element to add: ");
                        queue.enqueue(input.nextInt());
                        break;
                    }
                    case 2:{
                        System.out.println("Element removed remove: " + queue.dequeue());
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

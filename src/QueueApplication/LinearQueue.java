package QueueApplication;

class LinearQueue
{
    int SIZE;
    int[] queue;
    int front, rear;

    LinearQueue(int SIZE)
    {
        this.SIZE = SIZE;
        queue = new int[SIZE];
        front = rear = 0;
    }

    void enqueue(int data)
    {
        if (rear == SIZE)
            throw new RuntimeException("Queue is full");
        queue[rear++] = data;
    }

    int dequeue()
    {
        if (front == SIZE)
            throw new RuntimeException("Queue is Full");
        return queue[front++];
    }

    public static void main(String[] args)
    {
        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        for(int i =0 ; i < 4; i++)
        {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
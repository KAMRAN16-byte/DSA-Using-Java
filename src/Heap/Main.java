package Heap;


public class Main
{
    public static void main(String[] args)
    {
        PriorityQueue pq = new PriorityQueue(5);
        pq.offer(6);
        pq.offer(68);
        pq.offer(66);
        pq.offer(46);
        pq.offer(99);
        pq.poll();
        pq.peek();
        pq.pollAll();
    }
}

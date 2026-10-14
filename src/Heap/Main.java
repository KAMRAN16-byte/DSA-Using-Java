package Heap;
public class Main
{
    public static void main(String[] args)
    {
        Heapify hp = new Heapify(5);
        hp.add(4);
        hp.add(5);
        hp.add(7);
        hp.add(40);

        hp.display();
    }

}

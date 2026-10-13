package CircularLinkedList.DataInsertion;

class LinkedList
{
    Node head;
    int size;

    static class Node
    {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    LinkedList()
    {
        head = null;
        size = 0;


    }
}
public class DataInsertOperationLinkedList
{
}

package CircularLinkedList;

public class TailLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node tail;
    int size;

    public TailLinkedList() {
        tail = null;
        size = 0;
    }

    void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(tail == null){
            tail = newNode;
            newNode.next = tail;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
    }

    void add(int data){
        Node newNode = new Node(data);
        size++;
        if(tail == null){
            tail = newNode;
            newNode.next = tail;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    void addAt(int data, int pos){
        Node newNode = new Node(data);
        size++;
        if(tail == null){
            tail = newNode;
            newNode.next = tail;
            return;
        }
        if(pos <= 1){
            newNode.next = tail.next;
            tail.next = newNode;
            return;
        }
        Node temp = tail.next;
        for(int i = 1; i < pos - 1 && temp != tail; i++){
            temp = temp.next;
        }
        if(temp == tail){
            tail =  newNode;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void delete(){
        if(tail == null){
            throw new RuntimeException("Nullify Linked List");
        }
        if(tail.next == tail){
            tail = null;
            return;
        }
        Node temp = tail.next;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    void deleteFirst(){
        if(tail == null){
            throw new RuntimeException("Nullify Linked List");
        }
        if(tail.next == tail){
            tail = null;
            return;
        }
        tail.next = tail.next.next;
    }

    void deleteAt(int pos){
        if(tail == null){
            throw new RuntimeException("Nullify Linked List");
        }
        if(tail.next == tail){
            tail = null;
            return;
        }
        if(pos <= 1){
            tail.next = tail.next.next;
        }
        Node temp = tail.next;
        for(int i = 1 ; i < pos - 1 && temp.next != tail; i++){
            temp = temp.next;
        }
        if(temp.next == tail){
            tail = temp;
        }
        temp.next = temp.next.next;
    }

    void display(){
        if(tail == null){
            throw new RuntimeException("Nullify LinkedList!");
        }
        Node temp =  tail.next;
        do{
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while (temp != tail.next);
    }

    public static void main(String[] args) {
        final TailLinkedList list = new TailLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(10);
        list.addFirst(2);
        list.addFirst(1);
        list.addAt(5,5);
        list.deleteAt(3);
        list.deleteAt(4);
        list.addAt(5,5);
        list.addAt(50,50);
        list.addAt(40,4);

        list.display();

    }

}

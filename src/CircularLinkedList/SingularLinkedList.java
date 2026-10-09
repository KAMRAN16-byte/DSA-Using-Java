package CircularLinkedList;

class LinkedList {
    Node head;
    int size;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    LinkedList() {
        head = null;
        size = 0;
    }

    void add(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = newnode;
            newnode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newnode.next = head;
        temp.next = newnode;
    }

    void addFirst(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = newnode;
            newnode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newnode.next = head;
        temp.next = newnode;
        head = newnode;
    }

    void addAt(int data, int pos) {
        size++;
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            newnode.next = head;
            return;
        }
        Node temp = head;
        if (pos <= 1) {
            while (temp.next != head) {
                temp = temp.next;
            }
            newnode.next = head;
            temp.next = newnode;
            head = newnode;
            return;
        }
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    int delete() {
        if (head == null) {
            throw new RuntimeException("Nullified Linked List!");
        }
        size--;
        if (head.next == head) {
            head = null;
        }
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = head;
        return data;
    }

    int deleteFirst() {
        if (head == null) {
            throw new RuntimeException("Nullified Linked List!");
        }
        size--;
        int data = head.data;
        if (head.next == head) {
            head = null;
            return data;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        head = head.next;
        temp.next = head;
        return data;
    }

    int deleteAt(int pos) {
        if (head == null) {
            throw new RuntimeException("Nullified Linked List!");
        }
        size--;
        if (head.next == head) {
            int data = head.data;
            head = null;
            return data;
        }
        Node temp = head;
        if (pos <= 1) {
            while (temp.next != head) {
                temp = temp.next;
            }
            int data = head.data;
            head = head.next;
            temp.next = head;
            return data;
        }
        for (int i = 1; i < pos - 1 && temp.next.next != head; i++) {
                temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = temp.next.next;
        return data;
    }

    void display() {
        if (head == null) {
            throw new RuntimeException("Nullified Linked List!");
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("\n"+size);
    }


}


public class SingularLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAt(15, 88);
        list.addAt(67, 4);
        list.addAt(75, 4);
        list.addAt(7, 4);
        list.addAt(73, 4);
        list.addAt(79, 4);
        list.deleteAt(1);
        list.display();

    }
}

package StackApplication.ParanthesesBalancer;
class Stack {
    char[] arr;
    int top;
    int size;

    Stack() {
        size = 10;
        arr = new char[size];
        this.top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    void push(char x) {
        if (isFull()) {
            throw new RuntimeException("StackOverflow!");
        }
        arr[++top] = x;
    }

    char pop() {
        if (isEmpty()) {
            throw new RuntimeException("StackUnderflow!");
        }
        return arr[top--];
    }

    char peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return arr[top];
    }


}
public class ParantheseBalancer {

}

package StackApplication.InfixConversion;

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

public class Postfix {
    static int precedence(char ch) {
        return switch (ch) {
            case '$' -> 3;
            case '/', '*', '%' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    public static String postFix(String infix) {
        Stack operatorStack = new Stack();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char value = infix.charAt(i);

            if (value >= '0' && value <= '9') {
                postfix.append(value);
            } else if (value == '(') {
                operatorStack.push(value);
            } else if (value == ')') {
                while (operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(value)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(value);
            }
        }
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        System.out.println(postFix("4+6/7+8*(4+1)"));

    }
}




package StackApplication.PrefixEvalutaion;

import StackApplication.InfixConversion.Prefix;

class Stack {
    int[] arr;
    int top;
    int size;

    Stack() {
        size = 10;
        arr = new int[size];
        this.top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    void push(int x) {
        if (isFull()) {
            throw new RuntimeException("StackOverflow!");
        }
        arr[++top] = x;
    }

    int pop() {
        if (isEmpty()) {
            throw new RuntimeException("StackUnderflow!");
        }
        return arr[top--];
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return arr[top];
    }
}

public class PrefixEvaluation {
        static int calculation(int operand1, int operand2,char operator) {
            return switch (operator) {
                case '+' -> operand1 + operand2;
                case '-' -> operand1 - operand2;
                case '*' -> operand1 * operand2;
                case '/' -> operand1 / operand2;
                case '%' -> operand1 % operand2;
                default -> (int) Math.pow(operand1, operand2);
            };
        }

    static int prefixEvaluation(String Expression) {
            Stack stack = new Stack();
            for(int i = Expression.length() - 1; i >= 0; i--) {
                char value = Expression.charAt(i);
                if(value >= '0' && value <= '9') {
                    stack.push(value-'0');
                    continue;
                }
                stack.push(calculation(stack.pop(), stack.pop(), value));
            }
            return stack.pop();
    }

    public static void main(String[] args) {
            System.out.println(prefixEvaluation(Prefix.preFix("4+6/2+8*(4+1)")));

    }

}

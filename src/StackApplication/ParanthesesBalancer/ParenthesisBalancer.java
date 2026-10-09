package StackApplication.ParanthesesBalancer;

class Stack
{
    char[] arr;
    int top;
    int size;

    Stack()
    {
        size = 10;
        arr = new char[size];
        this.top = -1;
    }

    boolean isEmpty()
    {
        return top == -1;
    }

    boolean isFull()
    {
        return top == size - 1;
    }

    void push(char x)
    {
        if (isFull()) {
            throw new RuntimeException("StackOverflow!");
        }
        arr[++top] = x;
    }

    char pop()
    {
        if (isEmpty()) {
            throw new RuntimeException("StackUnderflow!");
        }
        return arr[top--];
    }

    char peek()
    {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return arr[top];
    }


}

public class ParenthesisBalancer
{
    boolean isBalanced(String s)
    {
        String opening = "([{";
        String closing = ")]}";
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (opening.indexOf(s.charAt(i)) != -1) {
                stack.push(s.charAt(i));
            } else if (closing.indexOf(s.charAt(i)) != -1) {
                if( stack.isEmpty() ) {
                    return false;
                }
                if (closing.indexOf(s.charAt(i)) == opening.indexOf(stack.peek())) {
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args)
    {
        ParenthesisBalancer balancer = new ParenthesisBalancer();

        System.out.println(balancer.isBalanced("([{]])()"));
    }
}


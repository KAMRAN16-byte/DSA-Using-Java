package StackApplication.DecendingStack;

import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        DescendingStack stack =  new DescendingStack(4);
        stack.add(6);
        stack.add(68);
        stack.add(69);
        stack.add(63);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.add(6);

        System.out.println(stack.peek());

    }


}

package StackApplication.InfixConversion;


public class Prefix {
    static int precedence(char x){
        return switch (x){
            case '$' -> 3;
            case '/', '*', '%' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }


    public static String preFix(String infix){
        StringBuilder prefix = new StringBuilder();
        Stack operatorStack = new Stack();

        for(int i = infix.length()-1; i >= 0; i--){
            char value = infix.charAt(i);

            if(value >= '0' && value <= '9'){
                prefix.append(value);
            }
            else if(value == ')'){
                operatorStack.push(value);
            }
            else if(value == '('){
                while(operatorStack.peek() != ')'){
                    prefix.append(operatorStack.pop());
                }
                operatorStack.pop();
            }
            else{
                while(!operatorStack.isEmpty() && precedence(operatorStack.peek()) > precedence(value)){
                    prefix.append(operatorStack.pop());
                }
                operatorStack.push(value);
            }

        }
        while(!operatorStack.isEmpty()){
            prefix.append(operatorStack.pop());
        }
        return prefix.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(preFix("4+6/7+8*(4+1)"));
    }


}


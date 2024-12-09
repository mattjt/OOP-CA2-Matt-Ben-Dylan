package org.example.Question9;

import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:Matthew Tomkins
 *  Class Group:Sd2b
 */
public class Question9 {
    public static void main(String[] args) throws Exception {
        String equation;
        Scanner scan = new Scanner(System.in);
        System.out.println("Question 9\n__________\n");
        while (true) {
            System.out.println("Please enter equation using ('0' to '9' and '+-*/()'\nEnter X to quit");
            equation = scan.nextLine().trim();

            if (equation.equalsIgnoreCase("x")) {
                System.out.println("Quiting program...");
                break;
            }
            else{
                try {
                    System.out.println("Result: "+calculator(equation));
                } catch (Exception e) {
                    System.out.println("Invalid input: "+ equation);
                }
            }
        }
    }

    public static int calculator(String equation) throws Exception {
        Stack<Integer> number = new Stack<>();
        Stack<String> operator = new Stack<>();
        String operators ="+-*/";
        String numbers ="0123456789";
        int count=0;

        while(count<equation.length()){//runs to the length of the input
            String input = equation.substring(count,count+1);

            if(equation.charAt(count)==' '){// - space
                count++;
            }

            else if(numbers.contains(input)){// -  num
                number.push(Integer.parseInt(input));//push to num stack
                count++;
            }

            else if(equation.charAt(count)=='('){// - open bracket
                operator.push(equation.substring(count,count+1));//push open bracket to op stack
                count++;
            }

            else if(operators.contains(input)){// - operator
                while(!operator.isEmpty() && precedenceOp(operator.peek()) >= precedenceOp(input)){
                    evaluateTop(number, operator );
                }
                operator.push(equation.substring(count,count+1));//push op to op stack
                count++;
            }

            else if(equation.charAt(count)==')'){// - close bracket
                while(!operator.peek().equals("(")){
                    evaluateTop(number, operator );
                }
                operator.pop();
                count++;
            }

            else{
                break;//error
            }
        }

        while (!operator.isEmpty()) {//finish off equation
            evaluateTop(number, operator);
        }
        return number.peek();
    }

    private static void evaluateTop(Stack<Integer> number, Stack<String> operator)  throws Exception{//does the equation of the top 2 numbers
        int y = number.pop();//removes top 2 numbers and operator
        int x = number.pop();
        String op = operator.pop();

        switch (op) {
            case "+":
                number.push(x + y);
                break;
            case "-":
                number.push(x - y);
                break;
            case "*":
                number.push(x * y);
                break;
            case "/":
                if (y == 0) {
                    throw new Exception("Cannot Divide by zero");
                }
                number.push(x / y);
                break;
        }
    }

    public static int precedenceOp(String op) {//checks order of precedence for operators
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }
}

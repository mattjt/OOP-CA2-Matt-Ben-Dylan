package org.example;

import org.example.Question1.Question1;
import org.example.Question10.Question10;
import org.example.Question11.Question11;
import org.example.Question2.Question2;
import org.example.Question3.Question3;
import org.example.Question4.Question4;
import org.example.Question5.Question5;
import org.example.Question6.Question6;
import org.example.Question7and8.Question7;
import org.example.Question7and8.Question8;
import org.example.Question9.Question9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\u001b[94mEnter a number (1-11) to run question, or 'quit' to exit:\u001b[0m");
            input = kb.nextLine().toLowerCase().trim();

            if (input.equals("quit")) {
                System.out.println("\u001b[31mExiting program.\u001b[0m");
                break;
            }

            try {
                switch (input) {
                    case "1":
                        Question1.main(args);
                        break;
                    case "2":
                        Question2.main(args);
                        break;
                    case "3":
                        Question3.main(args);
                        break;
                    case "4":
                        Question4.main(args);
                        break;
                    case "5":
                        Question5.main(args);
                        break;
                    case "6":
                        Question6.main(args);
                        break;
                    case "7":
                        Question7.main(args);
                        break;
                    case "8":
                        Question8.main(args);
                        break;
                    case "9":
                        Question9.main(args);
                        break;
                    case "10":
                        Question10.main(args);
                        break;
                    case "11":
                        Question11.main(args);
                        break;
                    default:
                        System.out.println("\u001b[31mError: Enter a number between 1 and 11\u001b[0m");
                }
            } catch (Exception e) {
                System.out.println("\u001b[31mError: Enter a valid number.\u001b[0m");
            }
        }
    }
}

package org.example.Question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name:ben hand
 * Class Group:SD2B
 */
public class Question3 {   //Nested HTML (Stack)

    /*
filename: name of the file to test.
*/
    public static boolean validate(String filename) throws FileNotFoundException {
        Stack<String> stack = new Stack<>();
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNext()) {
            String tag = fileScanner.next();

            if (tag.startsWith("</")) {

                if (stack.isEmpty()) {
                    return false;
                }
                String openTag = stack.pop();
                String expectedClose = "</" + openTag.substring(1);
                if (!tag.equals(expectedClose)) {
                    return false;
                }
            } else if (tag.startsWith("<") && tag.endsWith(">") && !tag.equals("<br>")) {
                stack.push(tag);
            } else if (!tag.equals("<br>")) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"./OOP-CA2-MT-BH-DM/tags_valid.txt", "./OOP-CA2-MT-BH-DM/tags_invalid.txt"};

        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }


}



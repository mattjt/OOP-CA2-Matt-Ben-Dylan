package org.example.Question4;

import java.util.Scanner;
import java.util.Stack;


/**
 *  Name: Matthew Tomkins
 *  Class Group: SD2b
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startRow=-1;
        int startCol = -1;
        int[][] matrix = floodFillStart();
        //for testing with a wall
        //matrix[5] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        System.out.println("Question 4\n__________\n");
        while(true){
            System.out.print("Enter starting row (0-9):");
            startRow = scan.nextInt();
            System.out.print("Enter starting column (0-9):");
            startCol= scan.nextInt();

            if(startRow<0 || startRow>9 || startCol<0 || startCol>9){
                System.out.println("Invalid row or column(0-9 only)");
            }else{break;}
        }

        display(matrix);

        fill(startRow, startCol, matrix);

        display(matrix);
    }

    // Starter function to create the 2D array and fill it with zeros
    public static int[][]  floodFillStart() {
        int[][] matrix = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                matrix[x][y] = 0;
            }
        }
        return matrix;
    }

    //function to display the image
    public static void display(int[][] arr)
    {
        System.out.println("\n__________________________________________\n");
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    //replaces 0s with numbers and increments, avoids -1s
    private static void fill(int r, int c, int[][] arr) {
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(r, c));
        int fillNum = 1;

        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            int row = current.row;
            int col = current.col;

            if (arr[row][col] == 0) {
                arr[row][col] = fillNum;//fill current cell
                fillNum++;//cell fill increments

                //adds new cells to stack from around the current cell:
                // North
                if (row > 0 && arr[row - 1][col] == 0) {
                    stack.push(new Cell(row - 1, col));
                }
                // East
                if (col < 9 && arr[row][col + 1] == 0) {
                    stack.push(new Cell(row, col + 1));
                }
                // South
                if (row < 9 && arr[row + 1][col] == 0) {
                    stack.push(new Cell(row + 1, col));
                }
                // West
                if (col > 0 && arr[row][col - 1] == 0) {
                    stack.push(new Cell(row, col - 1));
                }
            }
        }
    }
}

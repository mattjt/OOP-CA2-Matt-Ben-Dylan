package org.example.Question10;

import java.util.Stack;

public class Question10 {

    enum DIRECTION {
        UP, DOWN, LEFT, RIGHT
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        };

        System.out.println("Maze:");
        display(maze);

        solve(0, 0, 4, 4, maze);

        System.out.println("Maze after solving:");
        display(maze);
    }

    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static void solve(int startX, int startY, int exitX, int exitY, int[][] maze) {
        Stack<Position> stack = new Stack<>();
        stack.push(new Position(startX, startY));

        maze[startX][startY] = 2;

        while (!stack.isEmpty()) {
            Position current = stack.peek();

            if (current.x == exitX && current.y == exitY) {
                System.out.println("Path found!");
                return;
            }

            boolean moved = false;

            for (DIRECTION dir : DIRECTION.values()) {
                int newX = current.x, newY = current.y;

                switch (dir) {
                    case UP:
                        newX -= 1;
                        break;
                    case DOWN:
                        newX += 1;
                        break;
                    case LEFT:
                        newY -= 1;
                        break;
                    case RIGHT:
                        newY += 1;
                        break;
                }

                if (isValidMove(newX, newY, maze)) {
                    maze[newX][newY] = 2;
                    stack.push(new Position(newX, newY));
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                stack.pop();
            }
        }
        System.out.println("No path found!");
    }

    private static boolean isValidMove(int x, int y, int[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }
}


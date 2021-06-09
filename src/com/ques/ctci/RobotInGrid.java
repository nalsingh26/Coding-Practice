package com.ques.ctci;

import java.awt.*;
import java.util.*;
import java.util.Scanner;

class Point {
    int row;
    int col;

    public Point(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

public class RobotInGrid {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows followed by columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        if (r == 0 || c == 0)
            System.out.print("Invalid input");
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.out.format("Enter row %d (space separated): ", i + 1);
            for (int j = 0; j < c; j++)
                mat[i][j] = sc.nextInt();
            sc.nextLine();
        }
        HashSet<Point> failedPath = new HashSet<>();
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(mat, path, failedPath, r - 1, c - 1))
            printPath(path);
        else
            System.out.print("Path does not exist");
    }

    private boolean getPath(int[][] mat, ArrayList<Point> path, HashSet<Point> failedPath, int r, int c) {
        if (r < 0 || c < 0 || mat[r][c] == 0)
            return false;
        Point p = new Point(r, c);
        if (failedPath.contains(p))
            return false;
        if ((r == 0 && c == 0) || getPath(mat, path, failedPath, r - 1, c) || getPath(mat, path, failedPath, r, c - 1)) {
            path.add(p);
            return true;
        }
        else
            failedPath.add(p);
        return false;
    }

    private void printPath(ArrayList<Point> path) {
        for(Point p: path){
            System.out.format("%d,%d -> ", p.row, p.col);
        }
        System.out.print("end");
    }

}

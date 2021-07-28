package io.github.qxqrose.leetcode.day5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: qiu
 * 2021/7/23
 */
public class Question733 {

    public static void main(String[] args) {

        int[][] image= new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int[][] ints = floodFill(image, 1, 1, 2);
        for (int[] ints1 : image) {
            for (int anInt : ints1) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Deque<Integer> dequex = new ArrayDeque<>();
        Deque<Integer> dequey = new ArrayDeque<>();

        dequex.push(sr);
        dequey.push(sc);

        while(!dequex.isEmpty()) {
            Integer x = dequex.pop();
            Integer y = dequey.pop();
            int temp = image[x][y];
            if(temp == newColor) {
                continue;
            }
            image[x][y] = newColor;

            if(x > 0 && image[x-1][y] == temp) {
                dequex.push(x-1);
                dequey.push(y);
            }
            if(x+1 < image.length && image[x+1][y] == temp) {
                dequex.push(x+1);
                dequey.push(y);
            }

            if(y > 0 && image[x][y - 1] == temp) {
                dequex.push(x);
                dequey.push(y-1);
            }
            if(y+1 < image[x].length  && image[x][y + 1] == temp) {
                dequex.push(x);
                dequey.push(y+1);
            }

        }
        return image;
    }
}

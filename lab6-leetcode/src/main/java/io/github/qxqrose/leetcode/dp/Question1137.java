package io.github.qxqrose.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question1137 {

    public static void main(String[] args) {
        Question1137 question509 = new Question1137();
        System.out.println(question509.tribonacci(3));
    }

    public int tribonacci(int n) {
        int[] t = new int[n+1];
        if(n >= 0) {
            t[0] = 0;
        }
        if(n >= 1) {
            t[1] = 1;
        }
        if(n >= 2) {
            t[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            t[i] = t[i-3] + t[i-2] + t[i-1];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += t[i];
        }

        return result;
    }
}

package io.github.qxqrose.leetcode.dp;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question509 {

    public static void main(String[] args) {
        Question509 question509 = new Question509();
        System.out.println(question509.fib(3));
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib1(int n) {
        int[] f = new int[n+1];
        if(n >= 0) {
            f[0] = 0;
        }
        if (n >= 1) {
            f[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-2] + f[i-1];
        }

        return f[n];
    }
}

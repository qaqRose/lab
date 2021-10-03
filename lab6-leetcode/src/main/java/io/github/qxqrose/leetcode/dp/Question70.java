package io.github.qxqrose.leetcode.dp;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question70 {

    public static void main(String[] args) {
        Question70 question509 = new Question70();
        System.out.println(question509.climbStairs(3));
    }

    /**
     * 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // dp[i]= dp[i-1] + dp[i-2]

        int dp[]= new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}

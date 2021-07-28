package io.github.qxqrose.leetcode.day5;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: qiu
 * 2021/7/22
 */
public class Question3 {

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        // ascii码  128个
        int[] last = new int[128];
        // 初始化
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        // 结果
        int res = 0;
        // 窗口开始位置
        int start = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

}

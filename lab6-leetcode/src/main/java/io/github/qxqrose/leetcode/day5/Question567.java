package io.github.qxqrose.leetcode.day5;

import java.util.Arrays;

/**
 * @author: qiu
 * 2021/7/22
 */
public class Question567 {

    public static void main(String[] args) {

        System.out.println(checkInclusion("abc",
                "ccccbbbbaaaa"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int s1Num = 0;
        int hash1[] = new int[26];
        for (int i = 0; i < len1; i++) {
            hash1[s1.charAt(i) - 'a'] ++;
        }

        int[] hash2 = new int[26];

        for (int i = 0; i < len2; i++) {
           hash2[s2.charAt(i) - 'a']++;
           if(i >= len1) {
               if(Arrays.equals(hash1, hash2)) {
                   return true;
               }
               hash2[s2.charAt(i-len1) - 'a']--;
           }
        }
        return false;
    }
}

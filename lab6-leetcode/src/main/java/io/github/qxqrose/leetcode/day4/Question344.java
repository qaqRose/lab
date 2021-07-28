package io.github.qxqrose.leetcode.day4;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question344 {
    public static void main(String[] args) {


    }

    public void reverseString(char[] s) {
//        int start = 0;
//        int end = s.length - 1;
//        while(start < end) {
//            char temp = s[start];
//            s[start] = s[end];
//            s[end] = temp;
//            start ++ ;
//            end --;
//        }
        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            char temp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = temp;
        }
    }
}

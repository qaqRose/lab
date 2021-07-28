package io.github.qxqrose.leetcode.day4;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question557 {
    public static void main(String[] args) {


    }

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s2 : s1) {
            char[] chars = s2.toCharArray();
            reverseString(chars);
            sb.append(chars).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }


    public void reverseString(char[] s) {

        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            char temp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = temp;
        }
    }
}

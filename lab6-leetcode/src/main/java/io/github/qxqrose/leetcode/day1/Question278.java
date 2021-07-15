package io.github.qxqrose.leetcode.day1;

/**
 * @author: QXQ
 * @time: 2021/7/14 23:57
 * @desc: TODO
 * 278. 第一个错误的版本
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class Question278 {
    public static void main(String[] args) {
        int n =   2126753390;
        int bad = 1702766719;
//        2126753390
//        1702766719
        failVersion = bad;
        Question278 question278 = new Question278();
        System.out.println(question278.firstBadVersion(n));
    }


    static int failVersion;

    boolean isBadVersion(int version) {
        if(version >= failVersion) {
            return true;
        }
        return false;
    }


    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        //# 存在溢出风险
//        int mid = (left + right)/2;
        int mid = left + (right - left)/2;
        // 中间值不等于目标值，说明未找到目标
        // left < right 防止不存在值而死循环
        while (left < right) {
            // 中间值大于目标, 目标位置可能在左边
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                // 否则，可能在右边
                left = mid + 1;
            }

//            mid = (int)((0L + left + right)/2);
            mid = left + (right - left)/2;
        }
        return mid;
    }
}

package io.github.qxqrose.leetcode.day2;

/**
 * @author: QXQ
 * @time: 2021/7/15 23:21
 * @desc: TODO
 *
 * 977. 有序数组的平方
 */
public class Question997 {


    public static void main(String[] args) {
        Question997 question997 = new Question997();
//        int[] nums = new int[]{0,3,10};
        int[] nums = new int[]{-4,-1,0,3,10};
//        int[] nums = new int[]{-5,-3,-2,-1};

        int[] ints = question997.sortedSquares(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        // 前
        int start = 0;
        // 后
        int end = nums.length-1;
        // 从数组后面添加
        int i = end;
        while (i >= 0) {
            result[i--] = Math.abs(nums[start]) > Math.abs(nums[end]) ?
                    nums[start]*nums[start++] : nums[end]*nums[end--];
        }
        return result;

    }
}

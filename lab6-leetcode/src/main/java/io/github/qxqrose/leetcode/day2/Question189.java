package io.github.qxqrose.leetcode.day2;

/**
 * @author: QXQ
 * @time: 2021/7/15 23:48
 * @desc: TODO
 *
 * 189. 旋转数组
 */
public class Question189 {

    public static void main(String[] args) {
        Question189 question189 = new Question189();
//        int[] nums = new int[]{0,3,10};
        int[] nums = new int[]{1,2,3,4,5,6,7};
//        int[] nums = new int[]{-5,-3,-2,-1};

        int k = 3;

        question189.rotate_3(nums, k);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
            for (int num : nums) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }


    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}

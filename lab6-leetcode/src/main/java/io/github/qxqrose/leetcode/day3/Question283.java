package io.github.qxqrose.leetcode.day3;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question283 {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,0};
//        int[] nums = new int[]{0,0,1};
//        int[] nums = new int[]{0,1,0,3,12};
//        int[] nums = new int[]{1,0,1};
        int[] nums = new int[]{4,2,4,0,0,3,0,5,1,0};


        Question283 question283 = new Question283();
        question283.moveZeroes2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        int len = nums.length;
        for (int k = 0; k < len; k++) {
            if(nums[k] != 0) {
                nums[j++] = nums[k];
            }
        }
        while(j < len) {
            nums[j++] = 0;
        }
    }

    // 双指针实现（快慢指针）
// 时间复杂度 O(n)
// 空间复杂度 O(1)
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                if (slow != fast) { // 减少交换的次数
                    // 交换 fast 和 slow 指向的元素
                    int tmp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = tmp;
                }
                slow++;
            }
        }
    }


    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

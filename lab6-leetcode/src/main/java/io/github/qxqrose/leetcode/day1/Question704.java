package io.github.qxqrose.leetcode.day1;

/**
 * @author: QXQ
 * @time: 2021/7/14 23:29
 * @desc: TODO
 *704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 */
public class Question704 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target  = 22;
        System.out.println(search(nums, target));
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return 返回下标，不存在返回-1
     */
    public static int search(int[] nums, int target) {
        int length = nums.length;
        // 边界判断
        if(nums[0] == target) {
            return 0;
        }
        if(nums[length-1] == target) {
            return length-1;
        }
        if(nums[0] > target || nums[length-1] < target) {
            return -1;
        }
        int left = 1;
        int right = length - 2;
        int mid = (left + right)/2;
        // 中间值不等于目标值，说明未找到目标
        // left < right 防止不存在值而死循环
        while (nums[mid] != target && left < right) {
            // 中间值大于目标, 目标位置可能在左边
            if(nums[mid] > target) {
                right = mid;
            } else {
                // 否则，可能在右边
                left = mid + 1;
            }
            mid = (left + right)/2;
        }
        if(nums[mid] != target) {
            return -1;
        }
        return mid;
    }
}

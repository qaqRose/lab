package io.github.qxqrose.leetcode.day1;

/**
 * @author: QXQ
 * @time: 2021/7/15 0:32
 * @desc: TODO
 *
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class Question35 {

    /**
     * vm option  -ea 开启断言
     * @param args
     */
    public static void main(String[] args) {
        Question35 question35 = new Question35();
        int[] nums = new int[]{1,3,5,6};
        int target  = 5;
        assert question35.searchInsert(nums, target) == 2;

        target  = 2;
        assert question35.searchInsert(nums, target) == 1;

        target  = 7;
        assert question35.searchInsert(nums, target) == 4;

        target  = 0;
        assert question35.searchInsert(nums, target) == 0;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 标准二分法
        while (left <= right) {
            int mid = left + (right - left)/2;

            // 二分是 左闭右开，
            // 所有只有target大的情况下， 才取比左区间大的范围
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // nums[pos] < target <= nums[pos + 1]
        // 找到时， left == right
        // 找不到   left - 1 == right
        // left 满足 第一个大于等于target的位置
        return left;
    }
}

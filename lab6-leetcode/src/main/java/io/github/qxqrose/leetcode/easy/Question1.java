package io.github.qxqrose.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: qiu
 * 2021/8/3
 */
public class Question1 {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];

        for(int i =0; i<nums.length; i++) {
            int num = map.get(nums[i]);
            if(map.containsKey(target - num)) {
                result[0] = num;
                result[1] = nums[target - num];
            }
        }

        return result;
    }
}

package io.github.qxqrose.leetcode.day3;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question167 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};

        int target = 9;

        Question167 question283 = new Question167();
        int[] ints = question283.twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if(i>0 && numbers[i-1] == numbers[i]) {
                continue;
            }
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
                if(numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return null;
    }

}

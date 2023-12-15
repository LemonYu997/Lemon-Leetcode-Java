package problems.c0easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * T1 两数之和 https://leetcode.cn/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numsStr = scanner.nextLine();
        String targetStr = scanner.nextLine();
        scanner.close();

        String[] numsStrs = numsStr.split(",");
        int[] nums = new int[numsStrs.length];

        for (int i = 0; i < numsStrs.length; i++) {
            nums[i] = Integer.parseInt(numsStrs[i].trim());
        }

        int target = Integer.parseInt(targetStr.trim());

        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }

    /**
     * 解法1：暴力求解
     * 时间复杂度：O(N2)
     * 空间复杂度：O(1)
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 解法2：哈希表，只用遍历一次，key是值（前提nums中不会出现重复的数），value是索引
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }
}

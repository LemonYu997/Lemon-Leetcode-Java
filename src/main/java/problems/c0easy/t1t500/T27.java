package problems.c0easy.t1t500;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 27 移除元素 https://leetcode.cn/problems/remove-element/
 * 给定一个树组 nums 和一个值 val ，将nums中所有值为val的元素移除，返回移除后数组的长度
 *
 * 示例1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 备注：不需要考虑数组中超出新长度后面的元素，nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案
 *
 * 示例2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 */
public class T27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

        int val = 3;

        System.out.println(removeElement1(nums, val));
    }

    /**
     * 快慢指针解法
     */
    public static int removeElement1(int[] nums, int val) {
        int n = nums.length;
        //处理临界情况
        if (n == 0) {
            return 0;
        }

        //快指针遍历数组，慢指针更新数组
        int fast = 0;
        int slow = 0;

        //遍历整个数组
        while (fast < n) {
            //如果当前位置不是指定值val，就更新慢指针所处位置
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        return slow;
    }

    /**
     * 官方解法：双指针优化
     * 因为不需要考虑移除元素后的排列顺序，所以只要将后边不用移除的元素放在前边移除元素的位置就行
     * 使用双指针，从两侧向中间遍历
     */
    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            //如果左指针处元素要被移除，就把右指针位置的元素放过来并重新判断
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}

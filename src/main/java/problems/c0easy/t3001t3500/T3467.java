package problems.c0easy.t3001t3500;

import java.util.Arrays;

/**
 * 3467 将数组按照奇偶性转化 https://leetcode.cn/problems/transform-array-by-parity/description/
 * 给你一个整数数组 nums。请你按照以下顺序 依次 执行操作，转换 nums：
 * 将每个偶数替换为 0。
 * 将每个奇数替换为 1。
 * 按 非递减 顺序排序修改后的数组。
 * 执行完这些操作后，返回结果数组。
 *
 * 示例：
 * 输入1：nums = [4,3,2,1]
 * 输出1：[0,0,1,1]
 *
 * 输入2：nums = [1,5,1,4,2]
 * 输出2：[0,0,1,1,1]
 */
public class T3467 {
    /**
     * 自己实现：先转换后排序
     */
    public int[] transformArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }

        Arrays.sort(nums);
        return nums;
    }

    /**
     * 社区解法：根据奇偶个数生填充数组
     */
    public int[] transformArray1(int[] nums) {
        int[] cnt = new int[2];
        for (int num : nums) {
            cnt[num % 2]++;
        }
        // 前边根据偶数个数填充0
        Arrays.fill(nums, 0, cnt[0], 0);
        // 剩下的填充 1
        Arrays.fill(nums, cnt[0], nums.length, 1);
        return nums;
    }
}
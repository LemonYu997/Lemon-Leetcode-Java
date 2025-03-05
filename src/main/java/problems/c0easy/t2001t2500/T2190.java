package problems.c0easy.t2001t2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2190 数组中紧跟 key 之后出现最频繁的数字 https://leetcode.cn/problems/most-frequent-number-following-key-in-an-array/description/
 * 给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
 * 统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，target 的出现次数为满足以下条件的 i 的数目：
 * 0 <= i <= n - 2
 * nums[i] == key 且
 * nums[i + 1] == target 。
 * 请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的。
 *
 * 示例：
 * 输入1：nums = [1,100,200,1,100], key = 1
 * 输出1：100
 *
 * 输入2：nums = [2,2,2,2,3], key = 2
 * 输出2：2
 */
public class T2190 {
    /**
     * 自己实现：使用 MAP 统计每一个 target 及其出现的次数
     */
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        // 找到出现次数最多的值
        int maxCount = 0;
        int ans = 0;

        // 如果是最后一个数，则没有下一个数作为 target，因此只需要到 n - 1
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int temp = nums[i + 1];
                int tempCount = map.getOrDefault(temp, 0) + 1;

                // 更新最大值
                if (tempCount > maxCount) {
                    maxCount = tempCount;
                    ans = temp;
                }

                // 更新出现次数
                map.put(temp, tempCount);
            }
        }

        return ans;
    }

    /**
     * 优化解法：使用数组存储出现次数，因为 1 <= nums[i] <= 1000
     */
    public int mostFrequent1(int[] nums, int key) {
        int[] temp = new int[1001];
        int maxCount = 0;
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                // target
                int num = nums[i + 1];
                // 更新出现次数
                temp[num]++;

                // 如果出现次数最多则更新答案
                if (temp[num] > maxCount) {
                    maxCount = temp[num];
                    ans = num;
                }
            }
        }

        return ans;
    }
}

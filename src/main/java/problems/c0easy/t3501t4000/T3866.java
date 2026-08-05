package problems.c0easy.t3501t4000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3866 找到第一个唯一偶数 https://leetcode.cn/problems/first-unique-even-element/description/
 * 给你一个整数数组 nums。
 * 请你返回一个整数，表示 nums 中出现 恰好 一次的第一个 偶数（以数组下标最早为准）。如果不存在这样的整数，返回 -1。
 * 如果一个整数 x 能被 2 整除，那么它就被认为是 偶数。
 *
 * 示例：
 * 输入1：nums = [3,4,2,5,4,6]
 * 输出1：2
 *
 * 输入2：nums = [4,4]
 * 输出2：-1
 */
public class T3866 {
    /**
     * 社区解法：使用哈希表
     */
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.merge(num, 1, Integer::sum);
            }
        }

        for (int num : nums) {
            if (num % 2 == 0 && map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}

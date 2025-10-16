package problems.c0easy.t2501t3000;

import java.util.List;

/**
 * 2855 使数组成为递增数组的最少右移次数 https://leetcode.cn/problems/minimum-right-shifts-to-sort-the-array/description/
 * 给你一个长度为 n 下标从 0 开始的数组 nums ，数组中的元素为 互不相同 的正整数。
 * 请你返回让 nums 成为递增数组的 最少右移 次数，如果无法得到递增数组，返回 -1 。
 * 一次 右移 指的是同时对所有下标进行操作，将下标为 i 的元素移动到下标 (i + 1) % n 处。
 *
 * 示例：
 * 输入1：nums = [3,4,5,1,2]
 * 输出1：2
 *
 * 输入2：nums = [1,3,5]
 * 输出2：0
 *
 * 输入3：nums = [2,1,4]
 * 输出3：-1
 */
public class T2855 {
    /**
     * 社区解法
     */
    public int minimumRightShifts(List<Integer> nums) {
        Integer[] n = nums.toArray(new Integer[0]);
        int count = 0;
        int loc = n.length - 1;
        int small = n[0];

        for (int i = 0; i < n.length - 1; i++) {
            if (n[i] > n[i + 1]) {
                count++;
                if (count > 1 || n[i + 1] > small) {
                    return -1;
                }
                loc = i;
            }
            if (count == 1 && n[i + 1] > small) {
                return -1;
            }
        }
        return n.length - loc - 1;
    }
}

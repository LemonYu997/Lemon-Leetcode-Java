package problems.c0easy.t3501t4000;

/**
 * 3978 唯一中间元素 https://leetcode.cn/problems/unique-middle-element/description/
 * 给你一个长度为奇数 n 的整数数组 nums 。
 * 如果 nums 的下标中间元素在数组中 恰好 出现一次，返回 true 。否则返回 false 。
 *
 * 示例：
 * 输入1：nums = [1,2,3]
 * 输出1：true
 *
 * 输入2：nums = [1,2,2]
 * 输出2：false
 */
public class T3978 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean isMiddleElementUnique(int[] nums) {
        int[] cnt = new int[101];

        for (int num : nums) {
            cnt[num]++;
        }

        return cnt[nums[nums.length / 2]] == 1;
    }

    /**
     * 社区解法：反向思路，优化写法
     */
    public boolean isMiddleElementUnique1(int[] nums) {
        int mid = nums[nums.length / 2];
        int cnt = 0;
        for (int num : nums) {
            if (num == mid) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}

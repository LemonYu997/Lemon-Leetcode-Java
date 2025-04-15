package problems.c0easy.t2001t2500;

/**
 * 2293 极大极小游戏 https://leetcode.cn/problems/min-max-game/description/
 * 给你一个下标从 0 开始的整数数组 nums ，其长度是 2 的幂。
 *
 * 对 nums 执行下述算法：
 *
 * 设 n 等于 nums 的长度，如果 n == 1 ，终止 算法过程。否则，创建 一个新的整数数组 newNums ，
 * 新数组长度为 n / 2 ，下标从 0 开始。
 * 对于满足 0 <= i < n / 2 的每个 偶数 下标 i ，
 * 将 newNums[i] 赋值 为 min(nums[2 * i], nums[2 * i + 1]) 。
 * 对于满足 0 <= i < n / 2 的每个 奇数 下标 i ，
 * 将 newNums[i] 赋值 为 max(nums[2 * i], nums[2 * i + 1]) 。
 * 用 newNums 替换 nums 。
 * 从步骤 1 开始 重复 整个过程。
 * 执行算法后，返回 nums 中剩下的那个数字。
 *
 * 示例：
 * 输入1：nums = [1,3,5,2,4,8,2,2]
 * 输出1：1
 *
 * 输入2：nums = [3]
 * 输出2：3
 */
public class T2293 {
    /**
     * 自己实现：根据题意模拟
     */
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            int[] temp = new int[n / 2];
            for (int i = 0; i < n / 2; i++) {
                if (i % 2 == 0) {
                    temp[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    temp[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
            // 每次循环筛一半
            nums = temp;
            n /= 2;
        }

        return nums[0];
    }

    /**
     * 官方解法1：递归
     */
    public int minMaxGame1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] temp = new int[n / 2];
        for (int i = 0; i < temp.length; i++) {
            if (i % 2 == 0) {
                temp[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
            } else {
                temp[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
            }
        }
        return minMaxGame(temp);
    }

    /**
     * 官方解法2：原地修改
     */
    public int minMaxGame2(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            int m = n / 2;
            for (int i = 0; i < m; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    nums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
            n = m;
        }
        return nums[0];
    }
}

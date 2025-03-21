package problems.c0easy.t2001t2500;

/**
 * 2239 找到最接近 0 的数字 https://leetcode.cn/problems/find-closest-number-to-zero/description/
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。
 * 如果有多个答案，请你返回它们中的 最大值 。
 *
 * 示例：
 * 输入1：nums = [-4,-2,1,4,8]
 * 输出1:1
 *
 * 输入2：nums = [2,-1,1]
 * 输出2:1
 */
public class T2239 {
    /**
     * 自己实现：遍历一次
     */
    public int findClosestNumber(int[] nums) {
        // 答案最大值和其到0的距离
        int maxAns = Integer.MIN_VALUE;
        int minDis = Integer.MAX_VALUE;

        for (int num : nums) {
            int temp = Math.abs(num);
            // 如果距离最小，则更新
            if (temp < minDis) {
                maxAns = num;
                minDis = Math.abs(num);
            } else if (temp == minDis && num > maxAns) {
                // 如果距离相等，则选取较大的那个
                maxAns = num;
            }
        }

        return maxAns;
    }
}

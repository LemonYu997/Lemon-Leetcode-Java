package problems.c0easy.t501t1000;

import java.util.Arrays;

/**
 * 561 数组拆分 https://leetcode.cn/problems/array-partition/
 * 给定长度为2n的整数数组nums，将这些数分成n对，例如（a1, b1），(a2, b2)。。。
 * 使得从1~n的min(ai, bi)总和最大
 *
 * 示例：
 * 输入1：nums = [1,4,3,2]
 * 输出1：4
 * 解释：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 *
 * 输入2：nums = [6,2,6,5,1,2]
 * 输出2：9
 */
public class T561 {
    /**
     * 根据定义：最佳分法就是排序后，每相邻两个数分一组
     * 保证不会出现一个数值和另一个偏大的数值组合在一起
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        //从0开始间隔1位取
        int count = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            count += nums[i];
        }

        return count;
    }
}

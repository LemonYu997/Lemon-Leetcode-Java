package problems.c0easy;

/**
 * 303 区域和检索-数组不可变 https://leetcode.cn/problems/range-sum-query-immutable/
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *  NumArray(int[] nums) 使用数组 nums 初始化对象
 *  int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
 *  包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * 示例：
 * 输入1：["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出1：[null, 1, -1, -3]
 * 备注：NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class T303 {
    /**
     * 官方解法：前缀和
     */
    class NumArray {
        //存储前缀和
        private int[] preSum;

        public NumArray(int[] nums) {
            int n = nums.length;
            //实际存储时从1开始，preSum[0]初始化为0
            preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            // preSum[right + 1] 表示 nums[0 ~ right] 之和
            // preSum[left] 表示 nums[0 ~ left - 1] 之和
            return preSum[right + 1] - preSum[left];
        }
    }
}

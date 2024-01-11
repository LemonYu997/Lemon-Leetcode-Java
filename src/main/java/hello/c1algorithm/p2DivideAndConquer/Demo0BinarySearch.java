package hello.c1algorithm.p2DivideAndConquer;

/**
 * 分治思想：基于递归实现二分查找
 * 给定一个长度为 n 的有序数组 nums ，其中所有元素都是唯一的，请查找元素 target 。
 */
public class Demo0BinarySearch {
    /**
     * 基于递归实现二分查找
     */
    int binarySearch(int[] nums, int target) {
        int n = nums.length;
        // 求解问题 f(0, n-1)
        return dfs(nums, target, 0, n - 1);
    }

    /**
     * 二分查找：问题 f(i, j)
     */
    int dfs(int[] nums, int target, int i, int j) {
        // 若区间为空，代表无目标元素，返回 -1
        if (i > j) {
            return -1;
        }
        // 计算中点索引
        int m = (i + j) / 2;
        if (nums[m] < target) {
            // 递归子问题
            return dfs(nums, target, m + 1, j);
        } else if (nums[m] > target) {
            // 递归子问题
            return dfs(nums, target, i, m - 1);
        } else {
            // 找到目标元素，返回其索引
            return m;
        }
    }
}

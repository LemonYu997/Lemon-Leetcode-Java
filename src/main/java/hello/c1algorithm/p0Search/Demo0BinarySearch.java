package hello.c1algorithm.p0Search;

/**
 * 二分查找 基于分治策略的对有序数列的查找
 * 给定一个长度为 n 的数组 nums ，元素按从小到大的顺序排列且不重复。
 * 请查找并返回元素 target 在该数组中的索引。若数组不包含该元素，则返回 -1
 *
 * 前提条件：数组有序
 */
public class Demo0BinarySearch {
    /**
     * 二分查找：双闭区间
     * 数组有序
     */
    int binarySearch(int[] nums, int target) {
        // 初始化双闭区间 [0, n-1]，即 i,j 分别指向数组首元素、尾元素
        int i = 0;
        int j = nums.length - 1;
        // 当 i > j 时跳出
        while (i <= j) {
            // 计算中点索引
            int m = i + (j - i) / 2;
            // 当前值 > 目标值，说明目标值在左半区间内
            if (nums[m] > target) {
                // 更新右边界
                j = m - 1;
            } else if (nums[m] < target) {
                // 当前值 < 目标值，说明目标值在右半区间内
                // 更新左边界
                i = m + 1;
            } else {
                // 找到目标索引
                return m;
            }
        }

        // 未找到 返回 -1
        return -1;
    }

    /**
     * 二分查找 左闭右开区间
     */
    int binarySearchLCRO(int[] nums, int target) {
        // 初始化左闭右开区间 [0, n)
        // i j 分别指向数组 首元素、尾元素 + 1
        int i = 0;
        int j = nums.length;
        // 循环，当搜索区间为空时跳出（当 i = j 时为空）
        while (i < j) {
            int m = i + (j - i) / 2;
            if (nums[m] < target) {
                // target 在 [m + 1, j) 中
                i = m + 1;
            } else if (nums[m] > target) {
                // target 在 [i, m) 中
                j = m;
            } else {
                return m;
            }
        }
        return -1;
    }
}

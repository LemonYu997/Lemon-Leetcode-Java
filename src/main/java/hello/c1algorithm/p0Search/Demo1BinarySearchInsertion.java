package hello.c1algorithm.p0Search;

/**
 * 二分查找插入点 搜索目标元素的插入位置
 * 给定一个长度为 n 的有序数组 nums 和一个元素 target ,
 * 现将 target 插入数组 nums 中，并保持其有序性。
 * 若数组中已存在元素 target ，则插入到其左方。请返回插入后 target 在数组中的索引
 */
public class Demo1BinarySearchInsertion {
    /**
     * 数组中不存在重复元素时
     * 1、数组中存在 target 时，则插入位置就是 target 所处位置
     * 2、数组中不存在 target 时，插入最终 i 处的位置
     */
    public static int binarySearchInsertionSimple(int[] nums, int target) {
        // 初始化双闭区间 [0, n-1]
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] < target) {
                // target 在区间 [m+1, j] 中
                i = m + 1;
            } else if (nums[m] > target) {
                // target 在区间 [i, m-1] 中
                j = m - 1;
            } else {
                // 找到 target，返回插入点 m
                return m;
            }
        }
        // 未找到 target，返回插入点 i
        return i;
    }

    /**
     * 存在重复元素时
     *  先用普通二分查找找到对应的 target 所在索引
     *  当找到 target 时，说明元素在 [i, m-1] 区间中，使用 j = m-1 缩小区间
     */
    public static int binarySearchInsertion(int[] nums, int target) {
        // 初始化闭区间 [0, n-1]
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            // 计算中点索引
            int m = i + (j - i) / 2;
            if (nums[m] < target) {
                // target 在区间 [m+1, j] 中
                i = m + 1;
            } else if (nums[m] > target) {
                // target 在区间 [i, m-1] 中
                j = m -1;
            } else {
                // 首个小于 target 的元素在 [i, m-1] 中
                j = m - 1;
            }
        }
        return i;
    }
}

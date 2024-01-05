package hello.c1algorithm.p0Search;

/**
 * 二分查找边界
 * 给定一个长度为 n 的有序数组 nums ，其中可能包含重复元素。
 * 请返回数组中最左一个元素 target 的索引。若数组中不包含该元素，则返回 -1
 */
public class Demo2BinarySearchEdge {
    /**
     * 查找最左一个 target
     */
    int binarySearchLeftEdge(int[] nums, int target) {
        // 等价于查找 target 的插入点
        int i = Demo1BinarySearchInsertion.binarySearchInsertion(nums, target);
        // 未找到 target，返回 -1
        if (i == nums.length || nums[i] != target) {
            return -1;
        }
        // 找到
        return i;
    }

    /**
     * 查找右边界
     * 采用复用查找左边界的方法，将查找右边界转化为查找最左一个 target + 1
     */
    int binarySearchRightEdge(int[] nums, int target) {
        // 转化为查找最左一个 target + 1
        int i = Demo1BinarySearchInsertion.binarySearchInsertion(nums, target + 1);
        // j 指向最右一个 target
        int j = i - 1;
        // 未找到 target，返回 -1
        if (j == -1 || nums[j] != target) {
            return -1;
        }
        // 找到
        return j;
    }
}

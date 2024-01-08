package hello.c1algorithm.p1Sort;

/**
 * 插入排序：在未排序区间选择一个基准元素，将其与左侧已排序区间元素逐一比较大小，
 * 并将该元素插入到正确位置
 * 时间复杂度 O(n2)
 * 空间复杂度 O(1)
 */
public class Demo2InsertionSort {
    void insertionSort(int[] nums) {
        // 外循环，已排序元素数量为 1, 2, ..., n
        for (int i = 1; i < nums.length; i++) {
            // 基准元素
            int base = nums[i];
            // 已排序部分的最后一位
            int j = i - 1;
            // 内循环：将 base 插入到已排序部分的正确位置
            while (j >= 0 && nums[j] > base) {
                // 将 nums[j] 向后移动一位
                nums[j + 1] = nums[j];
                j--;
            }
            // 将base放在正确位置
            nums[j + 1] = base;
        }
    }
}

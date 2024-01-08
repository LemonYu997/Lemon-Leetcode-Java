package hello.c1algorithm.p1Sort;

/**
 * 选择排序：获取每轮循环中的未排序最小元素放入已排序区间中
 * 时间复杂度 O(n2)
 * 空间复杂度 O(1)
 */
public class Demo0SelectionSort {
    void selectionSort(int[] nums) {
        int n = nums.length;
        // 外循环，未排序区间为 [i, n-1]
        for (int i = 0; i < n - 1; i++) {
            // 内循环，找到未排序区间的最小元素
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[k]) {
                    // 记录最小元素的索引
                    k = j;
                }
            }
            // 将该最小元素与未排序区间的首个元素交换
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
}

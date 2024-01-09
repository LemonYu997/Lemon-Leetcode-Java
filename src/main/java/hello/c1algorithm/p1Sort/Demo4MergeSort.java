package hello.c1algorithm.p1Sort;

/**
 * 归并排序：基于分治思想，分为划分和合并阶段
 * 1、划分：通过递归不断地将数组从中间点处分开，将长数组转为短数组的排序问题
 * 2、合并：当子数组长度为 1 时终止划分，开始合并，持续地将左右两个较短的有序数组合并为一个较长的有序数组
 *
 * 时间复杂度：O(n logn)
 * 空间复杂度：O(n)
 */
public class Demo4MergeSort {
    /**
     * 归并排序
     */
    void mergeSort(int[] nums, int left, int right) {
        // 终止条件 子数组长度为 1 时
        if (left >= right) {
            return;
        }
        // 划分阶段
        int mid = (left + right) / 2;
        // 递归左子数组
        mergeSort(nums, left, mid);
        // 递归右子数组
        mergeSort(nums, mid, right);
        // 合并阶段
        merge(nums, left, mid, right);
    }

    /**
     * 合并左子数组和右子数组
     */
    void merge(int[] nums, int left, int mid, int right) {
        // 左子数组区间为 [left, mid]，右子数组区间为 [mid, right]
        // 创建一个临时数组 temp，用于存放合并后的结果
        int[] temp = new int[right - left + 1];
        // 初始化左子数组和右子数组的起始索引
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 当左右子数组都还有元素时，进行比较并将较小的元素复制到临时数组中
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        // 将左子数组和右子数组的剩余元素复制到临时数组中
        while (i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = nums[j];
            k++;
            j++;
        }
        // 将临时数组 temp 中的元素复制回原数组 nums 的对应区间
        for (k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }
}

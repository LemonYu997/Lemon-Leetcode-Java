package hello.c1algorithm.p1Sort;

/**
 * 冒泡排序：与相邻元素比较并交换，不断将最大元素放入正确位置
 * 时间复杂度 O(n2)
 * 空间复杂度 O(1)
 */
public class Demo1BubbleSort {
    // 冒泡排序
    void bubbleSort(int[] nums) {
        // 外循环：未排序区间为 [0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环，将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j+1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 效率优化，如果某轮冒泡中没有出现元素交换
     * 说明已经排序成功，可以直接退出
     */
    void bubbleSortWithFlag(int[] nums) {
        // 外循环：未排序区间为 [0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            // 初始化标志位
            boolean flag = false;
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    // 记录交换元素
                    flag = true;
                }
            }
            if (!flag)
                // 此轮“冒泡”未交换任何元素，直接跳出
                break;
        }
    }
}

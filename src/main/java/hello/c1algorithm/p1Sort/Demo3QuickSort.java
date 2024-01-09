package hello.c1algorithm.p1Sort;

/**
 * 快速排序：核心操作是哨兵划分
 * 哨兵划分：选择数组中某个元素为基准元素，将所有小于基准数的元素移到其左侧，大于基准数的元素移到其右侧
 *
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(n)
 */
public class Demo3QuickSort {
    /**
     * 交换
     */
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 哨兵划分
     * 目标：左子数组任意元素 <= 基准数 <= 右子组数任意元素
     */
    int partition(int[] nums, int left, int right) {
        // 以 nums[left] 为基准数
        int i = left;
        int j = right;
        while (i < j) {
            // 从右向左找首个小于基准数的元素
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            // 从左向右找首个大于基准数的元素
            while (i < j && nums[i] <= nums[right]) {
                i++;
            }
            // 交换这两个元素
            swap(nums, i, j);
        }
        // 将基准数交换至两子数组的分界线
        swap(nums, i, left);
        return i;
    }

    /**
     * 快速排序
     * 1、首先对原数组进行一次哨兵划分，得到未排序的左子数组和右子数组
     * 2、对左子数组和右子数组分别递归执行哨兵划分
     * 3、持续递归，直到子数组长度为 1 时终止
     *
     * @param left 初始传入 0
     * @param right 初始传入 nums.length - 1
     */
    void quickSort(int[] nums, int left, int right) {
        // 子数组长度为 1 时，递归终止
        if (left >= right) {
            return;
        }
        // 哨兵划分，得到哨兵所在位置，将其作为左右子数组分界线
        int pivot = partition(nums, left, right);
        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot, right);
    }

    /**
     * 由于上述写法默认将数组首元素作为基准数，如果数组倒序会退化成冒泡排序
     * 因此可以使用三个候选元素（数组的首、尾、中）的中位数作为基准数
     * 减少时间复杂度劣化的概率
     */
    int medianThree(int[] nums, int left, int mid, int right) {
        // 选取三个候选元素的中位数，这里使用异或运算简化代码
        // 异或规则为 0 ^ 0 = 1 ^ 1 = 0, 0 ^ 1 = 1 ^ 0 = 1
        if ((nums[left] < nums[mid]) ^ (nums[left] < nums[right])) {
            // 相当于 right < left < mid 或者 mid < left < right
            // 中位数都是 nums[left]
            return left;
        } else if ((nums[mid] < nums[left]) ^ (nums[mid] < nums[right])) {
            // 相当于 right < mid < left 或者 left < mid < right
            // 中位数都是 nums[mid]
            return mid;
        } else {
            return right;
        }
    }

    /**
     * 哨兵划分（三数取中值）
     */
    int partitionThree(int[] nums, int left, int right) {
        // 选取三个候选元素的中位数
        int med = medianThree(nums, left, (left + right) / 2, right);
        // 将中位数交换至数组最左侧
        swap(nums, left, med);
        // 以 nums[left] 为基准数
        int i = left;
        int j = right;
        while (i < j) {
            // 从右向左找首个小于基准数的元素
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            // 从左向右找首个大于基准数的元素
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            // 交换这两个元素
            swap(nums, i, j);
        }
        // 将基准数交换这两子数组分界线
        swap(nums, i, left);
        // 返回基准数索引
        return i;
    }

    /**
     * 尾递归优化
     * 在每轮哨兵排序完成后，比较两个子数组长度，仅对较短的子数组进行递归
     */
    void quickSort2(int[] nums, int left, int right) {
        // 子数组长度为 1 时终止
        while (left < right) {
            // 哨兵划分操作
            int pivot = partitionThree(nums, left, right);
            // 对两个子数组中较短的那个执行快速排序
            if (pivot - left < right - pivot) {
                // 递归排序左子数组
                quickSort2(nums, left, pivot - 1);
                // 剩余未排序区间为 [pivot+1, right]
                left = pivot + 1;
            } else {
                // 递归排序右子数组
                quickSort2(nums, pivot + 1, right);
                // 剩余未排序区间为 [left, pivot - 1]
                right = pivot - 1;
            }
        }
    }
}

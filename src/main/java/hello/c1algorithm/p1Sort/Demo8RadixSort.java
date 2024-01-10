package hello.c1algorithm.p1Sort;

/**
 * 基数排序：类似于计数排序，但是对于大数字（如 8 位学号）
 * 利用数组各位之间的递进关系，一次对每一位进行排序
 */
public class Demo8RadixSort {
    /**
     * 以 8 位学号为例，最低位是第 1 位，最高位是第 8 位
     * 1、初始化位数 k = 1
     * 2、对学号的第 k 位执行计数排序
     * 3、将 k 增加 1，继续第 2 步的迭代，直到所有位排完
     */
    void radixSort(int[] nums) {
        // 获取数组的最大元素，用于判断最大位数
        int m = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > m) {
                m = num;
            }
        }
        // 按照从低位到高位的顺序遍历
        for (int exp = 0; exp <= m; exp *= 10) {
            // 对数组元素的第 k 位执行计数排序
            // k = 1 -> exp = 1
            // k = 2 -> exp = 10
            // exp = 10^(k-1)
            countingSortDigit(nums, exp);
        }
    }

    /**
     * 计数排序 根据 nums 的第 k 位进行排序
     */
    void countingSortDigit(int[] nums, int exp) {
        // 十进制的位范围是 [0,9]，需要长度为 10 的桶数组
        int[] counter = new int[10];
        int n = nums.length;
        // 统计 0~9 各数字的出现次数
        for (int num : nums) {
            // 获取 nums[i] 第 k 位，记为 d
            int d = digit(num, exp);
            // 统计数字 d 的出现次数
            counter[d]++;
        }
        // 求前缀和，将出现次数转为数组索引
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
        }
        // 倒序遍历，根据桶内统计结果，将各元素填入 res
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int d = digit(nums[i], exp);
            // 获取 d 在数组中的索引
            int j = counter[d] - 1;
            // 将当前元素填入索引 j
            res[j] = nums[j];
            // 将 d 的数量减少 1
            counter[d]--;
        }

        // 覆盖原数组
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

    /**
     * 获取元素 num 的第 k 位，其中 exp = 10 ^ (k-1)
     */
    int digit(int num, int exp) {
        // 传入 exp 而非 k，可以避免重复执行次方运算
        return (num / exp) % 10;
    }
}

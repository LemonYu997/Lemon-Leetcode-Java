package hello.c1algorithm.p1Sort;

/**
 * 计数排序：通过统计元素数量进行排序，只适用于非负整数
 * 可以认为计数排序是桶排序在整型数据下的一个特例
 *
 * 时间复杂度 O(n+m)
 * 空间复杂度 O(n+m)
 */
public class Demo7CountingSort {
    /**
     * 简单实现：给定一个长度为 n 的非负整数数组 nums
     * 1、遍历数组，找到最大值 m，创建一个 m+1 的辅助数组 counter
     * 2、借助 counter 统计 nums 中各个数字出现的次数，counter[num]=num出现次数
     * 3、counter索引天然有序，遍历 counter，根据数字出现次数填入 nums 即可
     */
    void countingSortNaive(int[] nums) {
        //1、统计数组最大元素 m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        //2、统计各个数字出现次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }
        //3、遍历 counter，将各元素填入原数组 nums
        int i = 0;
        for (int num = 0; num < m + 1; num++) {
            for (int j = 0; j < counter[num]; j++) {
                nums[i] = num;
                i++;
            }
        }
    }

    /**
     * 基于前缀和的完整实现
     * 可排序对象，并且是稳定排序
     */
    void countingSort(int[] nums) {
        //1、统计数组最大元素 m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        //2、统计各个数字出现次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }
        //3、求 counter 的前缀和，将出现次数转为尾索引
        // 即 counter[num]-1 是 num 在 res 中最后一次出现的索引
        for (int i = 0; i < m; i++) {
            counter[i + 1] += counter[i];
        }
        //4、倒序遍历nums，将各元素填入结果数组
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            // 将 num 放置到对应索引处
            res[counter[num] - 1] = num;
            // 令前缀和自减 1，得到下次放置 num 的索引
            counter[num]--;
        }
        //使用结果数组 res 覆盖原数组 nums
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}

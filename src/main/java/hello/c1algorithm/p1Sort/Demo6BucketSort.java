package hello.c1algorithm.p1Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序：基于分治思想的非比较排序算法
 * 时间复杂度 O(n+k)
 * 空间复杂度 O(n+k)
 */
public class Demo6BucketSort {
    /**
     * 桶排序
     * 1、初始化 k 个桶，将 n 个元素分配到 k 个桶中
     * 2、对每个桶分别执行排序（采用编程语言内置函数）
     * 3、按照桶从小到大的顺序合并结果
     */
    void bucketSort(float[] nums) {
        // 初始化 k = n/2 个桶，预期向每个桶内分配两个元素
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }

        //1、将数组元素分配到各个桶中
        for (float num : nums) {
            // 输入数据范围为 [0, 1)，使用 num * k 映射到索引范围 [0, k-1]
            int i = (int) (num * k);
            // 将 num 添加到桶
            buckets.get(i).add(num);
        }
        //2、对各个桶执行排序
        for (List<Float> bucket : buckets) {
            // 使用内置排序，也可以自己实现
            Collections.sort(bucket);
        }
        //3、遍历桶合并结果
        int i = 0;
        for (List<Float> bucket : buckets) {
            for (Float num : bucket) {
                nums[i] = num;
                i++;
            }
        }
    }
}

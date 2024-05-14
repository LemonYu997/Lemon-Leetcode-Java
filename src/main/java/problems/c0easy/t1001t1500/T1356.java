package problems.c0easy.t1001t1500;

import java.util.*;

/**
 * 1356 根据数字二进制下 1 的数目排序 https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/description/
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 *
 * 示例：
 * 输入1：arr = [0,1,2,3,4,5,6,7,8]
 * 输出1：[0,1,2,4,8,3,5,6,7]
 *
 * 输入2：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出2：[1,2,4,8,16,32,64,128,256,512,1024]
 *
 * 输入3：arr = [10000,10000]
 * 输出3：[10000,10000]
 *
 * 输入4：arr = [2,3,5,7,11,13,17,19]
 * 输出4：[2,3,5,17,7,11,13,19]
 *
 * 输入5：arr = [10,100,1000,10000]
 * 输出5：[10,100,10000,1000]
 */
public class T1356 {
    /**
     * 自己实现：统计每个数的二进制中 1 个数，再进行排序
     */
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
            bit[num] = Integer.bitCount(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (bit[a] != bit[b]) {
                    return bit[a] - bit[b];
                } else {
                    return a - b;
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

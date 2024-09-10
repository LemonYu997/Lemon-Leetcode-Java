package problems.c0easy.t1501t2000;

import java.util.Arrays;
import java.util.Random;

/**
 * 1619 删除某些元素后的数组均值 https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/description/
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 *
 * 示例：
 * 输入1：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出1：2.00000
 *
 * 输入2：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * 输出2：4.00000
 *
 * 输入3：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
 * 输出3：4.77778
 *
 * 输入4：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
 * 输出4：5.27778
 *
 * 输入5：arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1]
 * 输出5：5.29167
 */
public class T1619 {
    /**
     * 自己实现：先排序，再按题意模拟
     */
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int lim = (int) (n * 0.05);
        int sum = 0;

        for (int i = lim; i < n - lim; i++) {
            sum += arr[i];
        }

        return (double) sum / (n - lim * 2);
    }

    /**
     * 社区解法：快速选择
     */
    public double trimMean1(int[] arr) {
        int len = arr.length;
        int count = len / 20;
        // 把最小的 count 个元素放到前面
        quickSelect(QuickSelectTypeEnum.min, arr, count);
        // 把剩余最大的 count 个元素放到前面
        quickSelect(QuickSelectTypeEnum.max, arr, count, len, count);
        // 前面 count*2 个元素, 都是要丢弃的
        long sum = 0;
        for (int i = count * 2; i < len; i++) {
            sum += arr[i];
        }
        return 1.0 * sum / (len - count * 2);
    }

    private static final Random r = new Random();

    /**
     * 快速选择法
     */
    public static void quickSelect(QuickSelectTypeEnum type, int[] arr, int k) {
        quickSelect(type, arr, 0, arr.length, k);
    }

    /**
     * 快速选择法
     * 经过选择后，arr[k]位置的元素，是数组 [from,to) 中第 k+1 大的元素
     */
    public static void quickSelect(QuickSelectTypeEnum type, int[] arr, int from, int to, int k) {
        int len = to - from;
        if (len <= 1) {
            return;
        }
        int markPos = r.nextInt(to - from) + from;
        int markValue = arr[markPos];
        swap(arr, markPos, to - 1);
        int left = from, right = to - 2;
        while (left < right) {
            if (type.compare(arr[left], markValue)) {
                left++;
            } else {
                swap(arr, left, right--);
            }
        }
        if (type.compare(arr[left], markValue)) {
            swap(arr, ++left, to - 1);
        } else {
            swap(arr, left, to - 1);
        }

        int pos = left - from;
        if (pos == k) {
            return;
        }
        if (pos < k) {
            quickSelect(type, arr, left + 1, to, k - pos - 1);
        } else {
            quickSelect(type, arr, from, left, k);
        }
    }

    private static void swap(int[] arr, int leftPos, int rightPos) {
        int t = arr[leftPos];
        arr[leftPos] = arr[rightPos];
        arr[rightPos] = t;
    }

    public static enum QuickSelectTypeEnum {
        min {
            @Override
            public boolean compare(int left, int right) {
                return left <= right;
            }
        },
        max {
            @Override
            public boolean compare(int left, int right) {
                return left >= right;
            }
        };

        public abstract boolean compare(int left, int right);
    }
}

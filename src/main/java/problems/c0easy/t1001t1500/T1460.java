package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1460 通过翻转子数组使两个数组相等 https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-subarrays/description/
 * 给你两个长度相同的整数数组 target 和 arr 。
 * 每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 *
 * 示例：
 * 输入1：target = [1,2,3,4], arr = [2,4,1,3]
 * 输出1：true
 *
 * 输入2：target = [7], arr = [7]
 * 输出2：true
 *
 * 输入3：target = [3,7,9], arr = [3,7,11]
 * 输出3：false
 */
public class T1460 {
    /**
     * 自己实现：根据题意，只要数组元素一致就能实现
     * 为方便对比可以先将两个数组排序
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}

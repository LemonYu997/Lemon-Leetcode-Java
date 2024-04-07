package problems.c0easy.t501t1000;

/**
 * 747 至少是其他数字两倍的最大数 https://leetcode.cn/problems/largest-number-at-least-twice-of-others/
 * 给定一个整数数组 nums，其中总是存在唯一的一个最大整数
 * 找到数组中最大元素并检查它是否至少是数组中每个其他数字的两倍，如果是，返回最大元素的下标，否则返回 -1
 *
 * 示例：
 * 输入1：nums = [3,6,1,0]
 * 输出1:1
 * 备注：最大整数是 6，至少是数组中其他元素的两倍
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2：-1
 * 备注：4 没有超过 3 的两倍大，所以返回 -1 。
 */
public class T747 {
    /**
     * 自己实现：找到第一大元素及其坐标和第二大的元素即可
     */
    public int dominantIndex(int[] nums) {
        int first = -1;     //最大值
        int second = -1;    //次大值
        int index = -1;     //最大值坐标

        for (int i = 0; i < nums.length; i++) {
            //更新最大值，将最大值传给次大值
            if (nums[i] > first) {
                if (first > second) {
                    second = first;
                }
                first = nums[i];
                index = i;
            } else if (nums[i] > second) {
                //如果当前数小于最大值，那判断是否需要更新次大值
                second = nums[i];
            }
        }

        //如果最大值比次大值 * 2大，返回最大值坐标，否则返回 -1
        if (first >= second * 2) {
            return index;
        } else {
            return -1;
        }
    }
}

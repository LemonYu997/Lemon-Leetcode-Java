package problems.c0easy;

import java.util.*;

/**
 * 496 下一个更大元素I https://leetcode.cn/problems/next-greater-element-i/
 * nums1中数组x的下一个更大元素是指x在nums2中对应位置右侧的第一个比x大的元素
 * 给定两个没有重复元素的数组nums1和nums2，下标从0开始计数，其中nums1时nums2的子集
 * 对于每个 0 <= i < nums1.length，找出满足 nums1[i] == nums2[j]的下标j
 * 并且在nums2确定nums2[j]的下一个更大元素，如果不存在下一个更大元素，那么本次查询的答案是-1
 *
 * 返回一个长度为nums1.length的数组ans作为答案，满足ans[i]是如上所述的下一个更大元素
 *
 * 示例：
 * 输入1：nums1 = [4,1,2], nums2 = [1,3,4,2]
 * 输出1：[-1,3,-1]
 * 备注：
 *  4在nums2中没有下一个更大元素，所以为-1
 *  1在nums2中的下一个更大元素为3
 *  2在nums2中没有下一个最大元素，所以为-1
 *
 * 输入2：nums1 = [2,4], nums2 = [1,2,3,4]
 * 输出2：[3, -1]
 */
public class T496 {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2};
        int[] nums2 = {1, 3, 4, 5};

        System.out.println(Arrays.toString(nextGreaterElement1(nums1, nums2)));
    }

    /**
     * 自己实现：暴力遍历
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        //对nums1中的每个数，都现在nums2中找到对应的索引
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            //n1的值在nums2中对应的索引
            int index = 0;
            //初始化为-1
            ans[i] = -1;

            //找到对应的索引
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == n1) {
                    index = j;
                    break;
                }
            }

            //从对应的索引开始往后进行遍历，找到比n1大的值
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > n1) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }

    /**
     * 自己实现：上述解法的代码优化 不需要声明新数组
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        //对nums1中的每个数，都现在nums2中找到对应的索引
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            //n1的值在nums2中对应的索引
            int index = 0;

            //找到对应的索引
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == n1) {
                    index = j;
                    break;
                }
            }

            //从对应的索引开始往后进行遍历，找到比n1大的值
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > n1) {
                    nums1[i] = nums2[j];
                    break;
                }
            }

            if (nums1[i] == n1) {
                nums1[i] = -1;
            }
        }

        return nums1;
    }

    /**
     * 官方解法1：暴力实现
     */
    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            int j = 0;
            //找到nums1中的数在num2中对应的索引
            while (j < n && nums2[j] != nums1[i]) {
                j++;
            }

            //从索引之后开始找更大的数
            int k = j + 1;
            while (k < n && nums2[k] < nums2[j]) {
                ++k;
            }

            res[i] = k < n ? nums2[k] : -1;
        }

        return res;
    }

    /**
     * 官方解法2：单调栈+哈希表
     */
    public static int[] nextGreaterElement4(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}

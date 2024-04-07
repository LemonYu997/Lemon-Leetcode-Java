package problems.c0easy.t1t500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 414 第三大的数 https://leetcode.cn/problems/third-maximum-number/
 * 给定一个费控数组，返回此数组中第三大的数，如果不存在，则返回数组中最大的数
 *
 * 示例：
 * 输入1：[3, 2, 1]
 * 输出1：1
 *
 * 输入2：[1, 2]
 * 输出2:2
 *
 * 输入3：[2, 2, 3, 1]
 * 输出3:1
 * 备注：要求返回第三大的数，是指在所有不同数字中排第三大的数。
 */
public class T414 {
    /**
     * 自己实现：使用List
     */
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        //默认是正序排序，最大值是最后一位
        list.add(nums[nums.length - 1]);

        //跳过相等值
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i - 1]);
        }

        //不足3位取最大值
        if (list.size() < 3) {
            return list.get(0);
        } else {
            return list.get(2);
        }
    }

    /**
     * 官方解法1：排序
     */
    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 1, diff = 1; i < nums.length; i++) {
            //此时 nums[i] 就是第三大的数
            if (nums[i] != nums[i - 1] && ++diff == 3) {
                return nums[i];
            }
        }
        return nums[0];
    }

    //反转数组
    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 官方解法2：有序集合
     */
    public int thirdMax2(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                //first()，返回TreeSet中最小的元素
                s.remove(s.first());
            }
        }

        return s.size() == 3 ? s.first() : s.last();
    }

    /**
     * 官方解法3：一次遍历
     * 用3个变量维护数组中的前三大值，可以先初始化为最小值
     * 在遍历过程中替换
     */
    public int thirdMax3(int[] nums) {
        //第一大
        long a = Long.MIN_VALUE;
        //第二大
        long b = Long.MIN_VALUE;
        //第三大
        long c = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }

        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }
}

package problems.c0easy;

import java.util.*;

/**
 * 26 删除有序数组中的重复项 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * 给定一个升序数组（含重复项），删除所有重复出现的元素，然后返回新数组的长度，顺序应保持一致。
 *
 * 示例1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 备注：后边的数据直接忽略
 *
 * 示例2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4,____]
 * 备注：后边的数据直接忽略
 */
public class T26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(removeDuplicates(nums));
    }

    /**
     * 官方解法：双指针
     * 在 i<j 时，如果出现nums[i]=nums[j]，那么这个 i~j 的范围内所有数字均相等，因为nums是有序的
     * 定义快慢指针，快指针表示遍历数组要到达的下标位置，慢指针表示下一个不同元素要填入的位置
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        //处理临界情况
        if (n == 0) {
            return 0;
        }
        //快慢指针，nums[0]是确定的，可以跳过
        int fast = 1;       //遍历整个nums
        int slow = 1;       //不重复的数

        while (fast < n) {
            //如果当前数字和上一个数字不重复
            if (nums[fast] != nums[fast-1]) {
                //更新慢指针处的数据，并将其向前移一位
                //相当于顺便更新了数组
                nums[slow] = nums[fast];
                ++slow;
            }
            //前进
            ++fast;
        }

        return slow;
    }
}

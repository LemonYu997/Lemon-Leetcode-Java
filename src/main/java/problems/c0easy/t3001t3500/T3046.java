package problems.c0easy.t3001t3500;

/**
 * 3046 分割数组 https://leetcode.cn/problems/split-the-array/description/
 * 给你一个长度为 偶数 的整数数组 nums 。你需要将这个数组分割成 nums1 和 nums2 两部分，要求：
 * nums1.length == nums2.length == nums.length / 2 。
 * nums1 应包含 互不相同 的元素。
 * nums2也应包含 互不相同 的元素。
 * 如果能够分割数组就返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：nums = [1,1,2,2,3,4]
 * 输出1：true
 *
 * 输入2：nums = [1,1,1,1]
 * 输出2：false
 *
 * 提示：
 * 1 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 *
 */
public class T3046 {
    /**
     * 自己实现：判断每个元素是否出现次数 >= 3 即可
     */
    public boolean isPossibleToSplit(int[] nums) {
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
            if (count[num] >= 3) {
                return false;
            }
        }

        return true;
    }
}

package problems.c0easy.t2001t2500;

/**
 * 2210 统计数组中峰和谷的数量 https://leetcode.cn/problems/count-hills-and-valleys-in-an-array/description/
 * 给你一个下标从 0 开始的整数数组 nums 。如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，则下标 i 是 nums 中，
 * 某个峰的一部分。类似地，如果两侧距 i 最近的不相等邻居的值均大于 nums[i] ，则下标 i 是 nums 中某个谷的一部分。对于相邻下标 i 和 j ，
 * 如果 nums[i] == nums[j] ， 则认为这两下标属于 同一个 峰或谷。
 * 注意，要使某个下标所做峰或谷的一部分，那么它左右两侧必须 都 存在不相等邻居。
 * 返回 nums 中峰和谷的数量。
 *
 * 示例：
 * 输入1：nums = [2,4,1,1,6,5]
 * 输出1：3
 *
 * 输入2：nums = [6,6,5,5,4,1]
 * 输出2：0
 */
public class T2210 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 1, 6, 5};
        System.out.println(countHillValley(nums));
    }


    /**
     * 自己实现：根据题意模拟，遍历
     */
    public static int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0;


        for (int i = 1; i < n - 1; i++) {
            // 因为不能为相同的峰和谷，所以第一个计算过之后第二个可以直接跳过
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            // 最近不相等元素的前后索引
            int l = i - 1;
            int r = i + 1;
            // 注意索引不要越界
            while (l > 0 && nums[l] == nums[i]) {
                l--;
            }
            while (r < n - 1 && nums[r] == nums[i]) {
                r++;
            }

            // 比较前后两个不相等元素是否都比本元素大，即为 谷，如果都小，则为 峰
            if ((nums[l] > nums[i] && nums[r] > nums[i])
                    || (nums[l] < nums[i] && nums[r] < nums[i])) {
                ans++;
            }
        }

        return ans;
    }
}

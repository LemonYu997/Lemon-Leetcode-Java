package problems.c0easy.t3501t4000;

/**
 * 3917 统计下标的相反奇偶性得分 https://leetcode.cn/problems/count-indices-with-opposite-parity/description/
 * 给你一个长度为 n 的整数数组 nums。
 * 下标 i 的 分数 定义为满足以下条件的下标 j 的数量：
 * i < j < n，并且
 * nums[i] 和 nums[j] 的奇偶性不同（一个为偶数，另一个为奇数）。
 * 返回一个长度为 n 的整数数组 answer，其中 answer[i] 表示下标 i 的分数。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4]
 * 输出1：[2,1,1,0]
 *
 * 输入2：nums = [1]
 * 输出2：[0]
 */
public class T3917 {
    /**
     * 自己实现：先统计整个数组的奇偶元素个数，再正序遍历递减
     */
    public int[] countOppositeParity(int[] nums) {
        int odds = 0;
        int evens = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }

        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // 注意要找到奇偶性不同的元素数，并且因为遍历过当前元素，就要把当前元素再对应的奇偶元素总数中 -1
            if (nums[i] % 2 == 0) {
                ans[i] = odds;
                evens--;
            } else {
                ans[i] = evens;
                odds--;
            }
        }
        return ans;
    }

    /**
     * 社区解法：遍历一次，倒序遍历
     */
    public int[] countOppositeParity1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] cnt = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i] & 1;
            ans[i] = cnt[x ^ 1];
            cnt[x]++;
        }
        return ans;
    }
}

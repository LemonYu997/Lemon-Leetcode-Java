package problems.c0easy.t3501t4000;

/**
 * 3663 出现频率最低的数字 https://leetcode.cn/problems/find-the-least-frequent-digit/description/
 * 给你一个整数 n，找出在其十进制表示中出现频率 最低 的数字。
 * 如果多个数字的出现频率相同，则选择 最小 的那个数字。
 * 以整数形式返回所选的数字。
 * 数字 x 的出现频率是指它在 n 的十进制表示中的出现次数。
 *
 * 示例：
 * 输入1：n = 1553322
 * 输出1：1
 *
 * 输入2：n = 723344511
 * 输出2：2
 */
public class T3663 {
    /**
     * 自己实现：遍历统计即可
     */
    public int getLeastFrequentDigit(int n) {
        int[] nums = new int[11];

        while (n > 0) {
            nums[n % 10]++;
            n /= 10;
        }

        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (ans == -1) {
                    ans = i;
                }
                if (nums[i] < nums[ans]) {
                    ans = i;
                }
                if (nums[i] == nums[ans] && i < ans) {
                    ans = i;
                }
            }
        }
        return ans;
    }


    /**
     * 社区解法：优化写法
     */
    public int getLeastFrequentDigit2(int n) {
        // 统计每个数字的出现次数
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }

        // 找出现次数最小的数字
        int minC = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            int c = cnt[i];
            if (c > 0 && c < minC) {
                minC = c;
                ans = i;
            }
        }
        return ans;
    }
}
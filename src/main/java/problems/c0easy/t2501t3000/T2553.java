package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2553 分割数组中数字的数位 https://leetcode.cn/problems/separate-the-digits-in-an-array/description/
 * 给你一个正整数数组 nums ，请你返回一个数组 answer ，
 * 你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。
 * 对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。
 * 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。
 *
 * 示例：
 * 输入1：nums = [13,25,83,77]
 * 输出1：[1,3,2,5,8,3,7,7]
 *
 * 输入2：nums = [7,1,3,9]
 * 输出2：[7,1,3,9]
 */
public class T2553 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();

        for (int num : nums) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                ans.add(s.charAt(i) - '0');
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 优化解法：直接拼接字符串
     */
    public int[] separateDigits1(int[] nums) {
        StringBuilder s = new StringBuilder();

        for (int num : nums) {
            s.append(num);
        }

        char[] chars = s.toString().toCharArray();
        int[] ans = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ans[i] = chars[i] - '0';
        }

        return ans;
    }

    /**
     * 社区解法：倒序遍历
     */
    public int[] separateDigits2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--){
            int temp = nums[i];
            // 此时针对每个数字都是从个位数获取的，所以相对题目要求是倒序的
            while (temp > 0) {
                list.add(temp % 10);
                temp = temp / 10;
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        // 最后再翻转一下并转成数组
        for (int i = list.size() - 1; i >= 0; i--) {
            ans[index++] = list.get(i);
        }
        return ans;
    }
}
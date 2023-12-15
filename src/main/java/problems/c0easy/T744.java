package problems.c0easy;

/**
 * 744 寻找比目标字母大的最小字母 https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 *
 * 示例：
 * 输入1：letters = ["c", "f", "j"]，target = "a"
 * 输出1："c"
 *
 * 输入2：letters = ["c","f","j"], target = "c"
 * 输出2："f"
 *
 * 输入3：letters = ["x","x","y","y"], target = "z"
 * 输出3："x"
 */
public class T744 {
    /**
     * 自己实现：遍历即可
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    /**
     * 官方解法：二分查找
     */
    public char nextGreatestLetter1(char[] letters, char target) {
        int length = letters.length;
        //排除临界情况
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        int low = 0;
        int high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return letters[low];
    }
}

package problems.c0easy.t501t1000;

/**
 * 680 验证回文串II https://leetcode.cn/problems/valid-palindrome-ii/description/
 * 给定一个字符串s，最多可以从中删除一个字符
 * 判断s能否成为回文字符串，如果能，返回true，否则返回false
 *
 * 示例：
 * 输入1：s = "aba"
 * 输出1：true
 *
 * 输入2：s = "abca"
 * 输出2：true
 * 备注：删除'c'
 *
 * 输入3：s = "abc"
 * 输出3：false
 */
public class T680 {
    /**
     * 自己实现：双指针判断
     */
    public boolean validPalindrome1(String s) {
        char[] chars = s.toCharArray();
        if (isPalindrome(chars)) {
            return true;
        }

        //挨个移除每一位，重新判断
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char[] newChars = newChars(chars, i);
            if (isPalindrome(newChars)) {
                return true;
            }
        }

        return false;
    }

    public boolean isPalindrome(char[] chars) {
        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public char[] newChars(char[] chars, int index) {
        int n  = chars.length;
        char[] ans = new char[n - 1];
        int j = 0;
        //跳过chars[index]，生成新数组
        for (int i = 0; i < n - 1; i++) {
            if (j == index) {
                j++;
            }
            ans[i] = chars[j];
            j++;
        }

        return ans;
    }

    /**
     * 官方解法：贪心，上述方案优化实现
     * 在移动指针发现不同的时候就删除判断
     */
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        //先判断是否前后相等
        while (low < high) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                //如果不同，就跳过左边一位或者右边一位，重新判断
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }

        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        int i = low;
        int j = high;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

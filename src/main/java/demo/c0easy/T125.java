package demo.c0easy;

/**
 * 125 验证回文串 https://leetcode.cn/problems/valid-palindrome/
 * 将所有大写字符转为小写字符，并移除所有非字母数字字符之后，如果正着读和反着读一样，则认为是回文串
 *
 * 示例：
 * 输入1：s = "A man, a plan, a canal: Panama"
 * 输出1：true
 * 备注："amanaplanacanalpanama" 是回文串
 *
 * 输入2：s = "race a car"
 * 输出2：false
 *
 * 输入3：s = " "
 * 输出3：true
 */
public class T125 {
    /**
     * 官方实现1：筛选+判断
     */
    public boolean isPalindrome1(String s) {
        //先处理字符串，全转为小写并去除特殊字符
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        //将字符串反转之后进行比较
        StringBuffer rsb = new StringBuffer(sb).reverse();
        return rsb.toString().equals(sb.toString());
    }

    /**
     * 官方实现2：双指针
     * 左右指针，分别在两侧向中间移动，判断每一个字符是否相同
     */
    public boolean isPalindrome2(String s) {
        StringBuffer sb = new StringBuffer();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int n = sb.length();
        //双指针
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 官方实现3：直接判断
     * 使用双指针，判断每一个字符
     */
    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left < right) {
            //排除非字母数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            //判断字符是否相等
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}

package problems.c0easy;

/**
 * 482 密钥格式化 https://leetcode.cn/problems/license-key-formatting/
 * 给定一个许可密钥字符串s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1组，并给定一个整数 k
 * 重新格式化字符串，使每一组包含k个字符，除了第一组可以短一点
 * 两组之间用破折号连接，并将所有小写字母转为大写字母
 *
 * 示例：
 * 输入1：S = "5F3Z-2e-9-w", k = 4
 * 输出1："5F3Z-2E9W"
 *
 * 输入2：S = "2-5g-3-J", k = 2
 * 输出2："2-5G-3J"
 */
public class T482 {
    /**
     * 自己实现：根据定义
     */
    public String licenseKeyFormatting(String s, int k) {
        //先转为大写并剔除所有 -
        char[] chars = s.toUpperCase().replaceAll("-", "").toCharArray();

        //处理额外情况 如s = "---"
        if (chars.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        //chars索引
        int i = 0;

        //如果 n / k除不尽，就说明首个字符串是小于k的，进行拼接
        int n = chars.length % k;
        if (n != 0) {
            for (int j = 0; j < n; j++) {
                sb.append(chars[j]);
                i++;
            }

            sb.append("-");
        }


        //拼接剩下的字符串
        while (i < chars.length) {
            for (int j = 0; j < k; j++) {
                sb.append(chars[i]);
                i++;
            }

            sb.append("-");
        }

        //删除最后多出来的 -
        sb.deleteCharAt(sb.lastIndexOf("-"));

        return sb.toString();
    }

    /**
     * 官方解法：上述代码的优化实现
     */
    public String licenseKeyFormatting1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        //先反向遍历，最后再反转
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                sb.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    sb.append("-");
                }
            }
        }

        //如果刚好为k的倍数时会在最后多加一个 - ，剔除即可
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}

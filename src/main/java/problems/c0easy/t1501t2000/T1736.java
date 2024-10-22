package problems.c0easy.t1501t2000;

/**
 * 1736 替换隐藏数字得到的最晚时间 https://leetcode.cn/problems/latest-time-by-replacing-hidden-digits/description/
 * 给你一个字符串 time ，格式为  hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 * 示例：
 * 输入1：time = "2?:?0"
 * 输出1："23:50"
 *
 * 输入2：time = "0?:3?"
 * 输出2："09:39"
 *
 * 输入3：time = "1?:22"
 * 输出3："19:22"
 */
public class T1736 {
    /**
     * 自己实现：根据题意模拟
     */
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        char c0 = time.charAt(0);
        char c1 = time.charAt(1);
        // c2 是冒号，跳过
        char c3 = time.charAt(3);
        char c4 = time.charAt(4);

        // 如果第一位是 ? 且第二位小于 4 且不为 ?，那就是 2
        if (c0 == '?' && (c1 < '4' || c1 == '?')) {
            sb.append('2');
        } else if (c0 == '?') {
            // 如果第一位是 ? 且第二位大于等于4 或者为 ?，那就是 1
            sb.append('1');
        } else {
            sb.append(c0);
        }

        // 如果第二位是 ?，那根据第一位，如果第一位是 0,1，则第二位是 9，如果第一位是 2,? ，第第二位是 3
        if (c1 == '?' && (c0 == '0' || c0 == '1')) {
            sb.append('9');
        } else if (c1 == '?' && (c0 == '?' || c0 == '2')) {
            sb.append('3');
        } else {
            sb.append(c1);
        }

        sb.append(":");

        // 如果第三位是 ?，那就是 5
        if (c3 == '?') {
            sb.append('5');
        } else {
            sb.append(c3);
        }
        // 如果第四位是 ?，那就是 9
        if (c4 == '?') {
            sb.append('9');
        } else {
            sb.append(c4);
        }

        return sb.toString();
    }

    /**
     * 官方解法：优化写法
     */
    public String maximumTime1(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }
}
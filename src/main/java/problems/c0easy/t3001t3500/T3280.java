package problems.c0easy.t3001t3500;

/**
 * 3280 将日期转换为二进制表示 https://leetcode.cn/problems/convert-date-to-binary/description/
 * 给你一个字符串 date，它的格式为 yyyy-mm-dd，表示一个公历日期。
 * date 可以重写为二进制表示，只需要将年、月、日分别转换为对应的二进制表示（不带前导零）
 * 并遵循 year-month-day 的格式。
 * 返回 date 的 二进制 表示。
 *
 * 示例：
 * 输入1：date = "2080-02-29"
 * 输出1："100000100000-10-11101"
 *
 * 输入2：date = "1900-01-01"
 * 输出2："11101101100-1-1"
 */
public class T3280 {
    public static void main(String[] args) {
        String date = "2080-02-29";
        System.out.println(date.substring(0,4));
        System.out.println(date.substring(5,7));
        System.out.println(date.substring(8));
    }

    /**
     * 自己实现：根据题意模拟即可
     */
    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(Integer.parseInt(date.substring(0, 4))));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(date.substring(5, 7))));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(date.substring(8))));
        return sb.toString();
    }
}

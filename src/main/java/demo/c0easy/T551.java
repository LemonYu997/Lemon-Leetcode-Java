package demo.c0easy;

/**
 * 551 学生出勤记录I https://leetcode.cn/problems/student-attendance-record-i/
 * 给定一个字符串s表示学生的出勤记录，包含以下三个字符：
 *  A：缺勤，Absent
 *  L：迟到，Late
 *  P：到场，Present
 * 同时满足以下条件可以获得出勤奖励：
 *  1、缺勤次数少于2天
 *  2、不存在连续3天或以上的迟到记录
 * 能获得出勤奖励返回true，否则返回false
 *
 * 示例：
 * 输入1：s = "PPALLP"
 * 输出1：true
 *
 * 输入2：s = "PPALLL"
 * 输出2：false
 */
public class T551 {
    /**
     * 自己实现：根据定义
     */
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;

        for (int i = 0; i < s.length(); i++) {
            //遇到缺勤就记一次
            if (s.charAt(i) == 'A') {
                countA++;
            }
            //遇到迟到就记一次，如果不是就清空
            if (s.charAt(i) == 'L') {
                countL++;
            } else {
                countL = 0;
            }

            if (countA >= 2 || countL >= 3) {
                return false;
            }
        }

        return true;
    }
}

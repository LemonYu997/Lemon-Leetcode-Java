package problems.c0easy.t2001t2500;

/**
 * 2446 判断两个事件是否存在冲突 https://leetcode.cn/problems/determine-if-two-events-have-conflict/description/
 * 给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
 * event1 = [startTime1, endTime1] 且
 * event2 = [startTime2, endTime2]
 * 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
 * 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
 * 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出1：true
 *
 * 输入2：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出2：true
 *
 * 输入3：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * 输出3：false
 */
public class T2446 {
    public static void main(String[] args) {
        String[] event1 = new String[]{"01:15", "02:00"};
        String[] event2 = new String[]{"02:00","03:00"};
        haveConflict(event1, event2);
    }

    /**
     * 自己实现：都转为当天分钟数判断是否存在交集
     */
    public static boolean haveConflict(String[] event1, String[] event2) {
        int a1 = Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3));
        int a2 = Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3));
        int b1 = Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3));
        int b2 = Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3));

        // 判断两个时间之间是否有交叉 当一个事件的结束时间是否小于另一个事件的开始时间时说明没交叉
        return !(b1 > a2 || a1 > b2);
    }

    /**
     * 官方解法：可以直接判断字符串大小
     */
    public boolean haveConflict1(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}

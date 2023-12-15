package problems.c0easy;

import java.util.Scanner;

/**
 * 14 最长公共前缀 https://leetcode.cn/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 */
public class T14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] strs = s.split(",");

        System.out.println(longestCommonPrefix1(strs));
    }

    //自己实现
    public static String longestCommonPrefix1(String[] strs) {
        //返回结果
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        //找到长度最小的字符串作为判断标准
        int length = 201;   //在这个题目里最大值201
        String mins = "";   //长度最小的字符串
        for (int i = 0; i < strs.length; i++) {
            int sl = strs[i].length();
            if (sl < length) {
                length = sl;
                mins = strs[i];
            }
        }

        //已经确认的公共字符串
        String commonStr = "";

        //获取第一个字符串的每一个字符，将其拼接
        for (int i = 1; i <= mins.length(); i++) {
            //当前测试的公共字符串
            String tmep = "";
            if (i == mins.length()) {
                tmep = mins;
            } else {
                tmep = mins.substring(0, i);
            }

            //遍历每一个字符串，判断是否有重复，没有重复就退出循环
            for (String str : strs) {
                String s = str.substring(0, i);
                //只要有一个字符串不满足这个公共字符串，就返回上一个公共字符串
                if (!s.equals(tmep)) {
                    return commonStr;
                }
            }

            //如果所有字符串都确认重复，就更新公共字符串
            commonStr = tmep;
        }

        return commonStr;
    }

    /**
     * 官方实现
     * 法一：横向扫描
     * 遍历每个字符串，不断更新最长公共前缀
     */
    public static String longestCommonPrefix2(String[] strs) {
        //处理临界情况
        if (strs == null || strs.length == 0) {
            return "";
        }

        //第一个字符串
        String prefix = strs[0];

        //遍历每一个字符串
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = getCommonString(prefix, strs[i]);
            //如果存在任意一个完全不相等的字符串，就可以直接退出
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    private static String getCommonString(String prefix, String str) {
        //得到公共子串和当前比较字符串的最小长度
        int length = Math.min(prefix.length(), str.length());
        //索引
        int index = 0;
        //遍历每个字符是否相等，直到找到不相等的索引位置
        while (index < length && prefix.charAt(index) == str.charAt(index)) {
            index++;
        }

        //返回公共字符串
        return prefix.substring(0, index);
    }

    /**
     * 官方实现
     * 法二：纵向扫描
     * 遍历字符串的每一列，如果所有字符串相同索引位置全相同，那就更新公共前缀
     */
    public static String longestCommonPrefix3(String[] strs) {
        //处理临界情况
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;

        //遍历第一个字符串的每一个字符
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            //遍历剩下的每个字符串
            for (int j = 1; j < count; j++) {
                //判断i == strs[j].length()是为了防止索引越界
                //如果出现不相等的字符串就返回
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    //截取不包含索引为i的字符串，因为当前i位置不满足相等条件，实际上是返回到上一个字符的位置
                    return strs[0].substring(0, i);
                }
            }
        }

        //全部满足，那当前第一个字符串就是公共字符串
        return strs[0];
    }

    /**
     * 官方实现
     * 法三：分治
     * 先每两个字符串得到一个公共字符串，再比较每两个公共字符串，一直向下递归
     */
    public static String longestCommonPrefix4(String[] strs) {
        //处理临界情况
        if (strs == null || strs.length == 0) {
            return "";
        }

        return getCommonPrefix2(strs, 0, strs.length - 1);
    }

    //递归，将字符串分组，再分别获得其最小公共字符串
    public static String getCommonPrefix2(String[] strs, int start, int end) {
        //只剩一个时就是最终结果
        if (start == end) {
            return strs[start];
        } else {
            //中间长度
            int mid = (end - start) / 2 + start;
            //分成两边找最小字符串，这里递归，所以最终返回的是左边和右边的公共字符串
            String lcpLeft = getCommonPrefix2(strs, start, mid);
            String lcpRight = getCommonPrefix2(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    //得到两个字符串的最长公共字符串
    public static String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        //遍历每一个字符，直到找到不相等的字符为止
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }

        //全都相等，那就返回较短的那个字符串作为公共前缀
        return lcpLeft.substring(0, minLength);
    }

    /**
     * 官方实现
     * 法四：二分查找
     * 公共前缀肯定不会超过最短的字符串，在这个长度范围内每次判断一半的字符串是否相等
     * 相等的话前缀肯定大于一半，不相等的话前缀肯定小于一半
     */
    public static String longestCommonPrefix5(String[] strs) {
        //处理临界情况
        if (strs == null || strs.length == 0) {
            return "";
        }

        //找到最短的字符串长度
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        //开始二分查找
        int low = 0;            //低索引位
        int high = minLength;   //高索引位
        while (low < high) {
            //每次算一半
            int mid = (high - low + 1) / 2 + low;
            //如果全相等，就向上查找，如果不相等，就向下查找
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, low);
    }

    //判断到指定索引位的字符串是否为strs的公共前缀
    public static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;

        //遍历每个字符串，判断前length位是否全相等
        for (int i = 0; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
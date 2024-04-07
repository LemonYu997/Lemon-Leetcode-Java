package problems.c0easy.t1t500;

import java.util.*;

/**
 * 20 有效的括号 https://leetcode.cn/problems/valid-parentheses/
 * 给定一个只包含 ( ) { } [ ]的字符串，判断其是否有效：
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 *  每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 */
public class T20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        System.out.println(isValid1(s));
    }

    //自己实现
    public static boolean isValid1(String s) {
        //分解每一个字符
        char[] chars = s.toCharArray();
        //存储左括号
        List<Character> temp = new ArrayList<>();

        //右括号的映射关系
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');


        //遍历每一个字符
        for (char c : chars) {
            //如果当前括号是左括号，就存入缓存list中
            if (!map.containsKey(c)) {
                temp.add(c);
            } else {
                //如果是右括号，判断temp中的最后一位是不是该右括号对应的左括号
                //不是的话就返回false
                //如果temp已经空了而遇倒的是右括号，同样返回false
                if (temp.size() == 0 || temp.get(temp.size() - 1) != map.get(c)) {
                    return false;
                }
                //是的话就将temp最后一位消除
                temp.remove(temp.size() - 1);
            }
        }

        //判断temp是否为空，为空即说明全部对应上了
        return temp.size() == 0;
    }

    /**
     * 官方解法：栈
     * 字符串长度一定是偶数，奇数直接排除
     * 遇倒左括号入栈，遇倒右括号将其对应的右括号出栈，不一致时就为false
     */
    public static boolean isValid2(String s) {
        //字符串长度一定是偶数，奇数直接排除
        if (s.length() % 2 == 1) {
            return false;
        }

        //右括号的映射关系
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        //定义栈
        Deque<Character> stack = new LinkedList<>();
        //遍历每一个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                //右括号出栈
                stack.pop();
            } else {
                //左括号入栈
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
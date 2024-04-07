package problems.c0easy.t501t1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 728 自除数 https://leetcode.cn/problems/self-dividing-numbers/
 * 自除数 是指可以被它包含的每一位数整除的数。
 * 如：128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0
 * 自除数 不允许包含 0 。
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 *
 * 示例：
 * 输入1：left = 1, right = 22
 * 输出1：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 * 输入2：left = 47, right = 85
 * 输出2：[48,55,66,77]
 */
public class T728 {
    /**
     * 自己实现：根据定义
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int num = i;
            boolean flag = true;

            //除以每一位
            while (num != 0) {
                int n = num % 10;   //当前位
                num = num / 10;     //往前推一位

                //如果当前位为0，不符合条件
                if (n == 0) {
                    flag = false;
                    break;
                }
                //如果除以当前位除不尽，不符合条件
                if (i % n != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(i);
            }
        }

        return list;
    }
}

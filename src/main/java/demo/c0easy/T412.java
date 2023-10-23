package demo.c0easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412 Fizz Buzz https://leetcode.cn/problems/fizz-buzz/
 * 给定一个整数n，找出从1到n各个整数的Fizz Buzz表示，并用字符串数组answer（下标从1开始）返回结果
 * 其中：
 * naswer[i] == "FizzBuzz"如果i同时是3和5的倍数
 * naswer[i] == "Fizz"如果i是3的倍数
 * naswer[i] == "Buzz"如果i是5的倍数
 * naswer[i] == i 上述条件不满足
 *
 * 示例：
 * 输入1：n = 3
 * 输出1：["1","2","Fizz"]
 *
 * 输入2：n = 5
 * 输出2：["1","2","Fizz","4","Buzz"]
 *
 * 输入3：n = 15
 * 输出3：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class T412 {
    /**
     * 自己实现：根据定义
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add("" + i);
            }
        }

        return list;
    }
}

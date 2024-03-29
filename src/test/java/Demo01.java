import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    @Test
    public void test01() {
        int a = 0;
        int b = 0;

        //先取值再自增，所以这里输出0，但实际0+1=1
        System.out.println(a++);
        //先自增再取值，所以这里输出1+1=2
        System.out.println(++a);
    }

    @Test
    public void test02() {
        int a = 1;
        int b = 1;

        int sum = (a + b) / 2;

        System.out.println(sum % 2);
    }

    @Test
    public void test03() {
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hello";
        String s4 = new String("hello");

        //equals比较内容，都为true
        System.out.println(s1.equals(s2));  //true
        System.out.println(s2.equals(s4));  //true

        //==比较地址
        System.out.println(s1 == s2);       //false，一个常量池，一个是引用对象
        System.out.println(s1 == s3);       //同一个常量池
        System.out.println(s2 == s4);       //两个不同地址

        System.out.println(s2 == "hello");  //false,一个引用对象，一个常量池
        s2 = s1;
        System.out.println(s2 == "hello");  //同一个地址
    }

    @Test
    public void test04() {
        Integer a = 1234;
        Integer b = new Integer(1234);

        System.out.println(a == b);
    }

    @Test
    public void test05() {
        List<String> list = new ArrayList<>();
    }

    @Test
    public void test06() {
        Map<Integer, Integer> map = new HashMap<>();
        Integer put = map.put(1, 4);
        System.out.println(put);
    }

    @Test
    public void test07() {
        try {
            int a = 2;
            int b = 0;
            a = a / (b + 1);
            System.out.println("忽略");
        } catch (ArithmeticException ignored) {

        }
    }
}

import org.junit.Test;

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
}

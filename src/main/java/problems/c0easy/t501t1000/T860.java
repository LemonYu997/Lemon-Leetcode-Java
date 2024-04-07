package problems.c0easy.t501t1000;

/**
 * 860 柠檬水找零 https://leetcode.cn/problems/lemonade-change/
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买产品，
 * （按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后付 5 美元、10 美元或 20 美元。
 * 必须给每个顾客正确找零，也就是说净交易是每位顾客向付 5 美元。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：bills = [5,5,5,10,20]
 * 输出1：true
 *
 * 输入2：bills = [5,5,10,10,20]
 * 输出2：false
 */
public class T860 {
    /**
     * 自己实现：使用 int[] 存储零钱
     * int[0] 表示剩余 5 元的个数
     * int[1] 表示剩余 10 元的个数
     */
    public boolean lemonadeChange(int[] bills) {
        // 因为顾客最多只会付 20 元，因此 20 元不能用来找零
        int[] money = new int[2];

        for (int bill : bills) {
            // 5 美元直接存入
            if (bill == 5) {
                money[0]++;
            }
            // 10 元需要找 5 元零钱
            if (bill == 10) {
                if (money[0] < 1) {
                    return false;
                }
                // 减去一张 5 元，存入一张 10 元
                money[0]--;
                money[1]++;
            }
            // 20 元需要一个 10 元和 一个 5 元或者 3个 5元
            if (bill == 20) {
                // 优先用 10 元，5 元的还可以给 10 元找零用
                if (money[1] >= 1 && money[0] >= 1) {
                    money[1]--;
                    money[0]--;
                } else if (money[0] >= 3) {
                    money[0] = money[0] - 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

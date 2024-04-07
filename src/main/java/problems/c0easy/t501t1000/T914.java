package problems.c0easy.t501t1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 914 卡牌分组 https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/
 * 给定一副牌，每张牌上都写着一个整数。
 * 需要选定一个数字 X，使整副牌按下述规则分成 1 组或更多组：
 * 1、每组都有 X 张牌。
 * 2、组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例：
 * 输入1：deck = [1,2,3,4,4,3,2,1]
 * 输出1：true
 * 备注：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 示例：
 * 输入2：deck = [1,1,1,2,2,2,3,3]
 * 输出2：false
 */
public class T914 {
    /**
     * 官方解法：暴力
     * 从 2 开始，枚举 X
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        // 因为deck[i] < 10000，所以直接创建一个 10000 大小的数组存储每个数出现的次数
        int[] count = new int[10000];
        // 对所有数字计数
        for (int i : deck) {
            count[i]++;
        }

        // 记录所有数字出现的有效次数
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        for (int X = 2; X <= N; X++) {
            if (N % X == 0) {
                boolean flag = true;
                // 每个数字出现的次数都应该是 X 的倍数
                for (Integer value : values) {
                    if (value % X != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 官方解法2：最大公约数
     */
    public boolean hasGroupsSizeX1(int[] deck) {
        int[] count = new int[10000];
        for (int i : deck) {
            count[i]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                // 初始化g
                if (g == -1) {
                    g = count[i];
                } else {
                    // 求最大公约数
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}

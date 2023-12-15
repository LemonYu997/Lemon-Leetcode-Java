package problems.c0easy;

/**
 * 605 种花问题 https://leetcode.cn/problems/can-place-flowers/
 * 一个由 0 和 1 组成的整数数组 flowerbed 表示花坛，其中 0 表示没种花，1 表示种了花
 * 有一个数 n，在不到种植规则的情况下种入 n 朵花，能则返回 true，否则返回 false
 *
 * 示例：
 * 输入1：flowerbed = [1,0,0,0,1], n = 1
 * 输出1：true
 *
 * 输入2：flowerbed = [1,0,0,0,1], n = 2
 * 输出2：false
 */
public class T605 {
    /**
     * 自己实现：遍历实现
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int l = flowerbed.length;
        // i 和 i - 1 和 i + 1 都必须为0时才能种上
        for (int i = 0; i < l; i++) {
            //在首位
            if (i == 0) {
                //如果当前位为0且存在下一位时且下一位为0时 可以种
                if (l >= 2  && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (l == 1 && flowerbed[i] == 0) {
                    //只有1位且为0时，可以种
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i == l - 1 && l != 1) {
                //在末位且长度超过2个且当前坛子为0时且前一位是0时，即可种
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                //在中间且前后都为0时
                flowerbed[i] = 1;
                n--;
            }

            if (n <= 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * 官方实现：贪心
     */
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        //可种数量
        int count = 0;
        int l = flowerbed.length;
        //前一个种下花朵的位置
        int prev = -1;

        for (int i = 0; i < l; i++) {
            //当前位置有花时
            if (flowerbed[i] == 1) {
                //前几位全部没有花时（因为prev没有更新），即可以种 i / 2向下取整位的花
                if (prev < 0) {
                    count += i / 2;
                } else {
                    //两朵花之间可以种这么多花
                    count += (i - prev - 2) / 2;
                }
                //满足条件，返回结果
                if (count >= n) {
                    return true;
                }
                //更新上一朵花的位置
                prev = i;
            }
        }
        //计算最后一个区间内可种花的位置 [prev~l-1]
        if (prev < 0) {
            count += (l + 1) / 2;
        } else {
            count += (l - prev - 1) / 2;
        }

        return count >= n;

    }
}

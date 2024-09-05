package problems.c0easy.t1501t2000;

/**
 * 1603 设计停车系统 https://leetcode.cn/problems/design-parking-system/description/
 * 请你给一个停车场设计一个停车系统。
 * 停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * 请你实现 ParkingSystem 类：
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，
 * 三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。
 * carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。
 * 一辆车只能停在  carType 对应尺寸的停车位中。
 * 如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *
 * 示例：
 * 输入1：["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出1：[null, true, true, false, false]
 */
public class T1603 {
    /**
     * 根据题意模拟，每个车位维护一个计数器
     */
    class ParkingSystem {
        int big, medium, small;

        // 初始化车位
        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        // 判断车位是否满了
        public boolean addCar(int carType) {
            if (carType == 1) {
                if (big > 0) {
                    big--;
                    return true;
                }
            } else if (carType == 2) {
                if (medium > 0) {
                    medium--;
                    return true;
                }
            } else if (carType == 3) {
                if (small > 0) {
                    small--;
                    return true;
                }
            }
            return false;
        }
    }
}

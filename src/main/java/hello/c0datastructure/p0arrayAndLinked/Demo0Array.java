package hello.c0datastructure.p0arrayAndLinked;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 数组
 * 将相同类型的元素存储在连续的内存空间中
 * <p>
 * 常用操作：
 * 1、初始化
 * 2、访问元素
 * 3、插入元素
 * 4、删除元素
 * 5、遍历元素
 * 6、查找元素
 * 7、扩容元素
 */
public class Demo0Array {
    public static void main(String[] args) {
        //1、初始化
        int[] arr = new int[5]; //默认初始化为 {0, 0, 0, 0, 0}
        int[] nums = {1, 3, 2, 5, 4};

        //2、随机访问元素 时间复杂度 O(1)
        int num = randomAccess(nums);
        System.out.println(num);

        //3、插入元素 时间复杂度 O(n)
        insert(nums, 99, 2);

        //4、插入元素 时间复杂度 O(n)
        remove(nums, 3);

        //5、查找元素 时间复杂度 O(n)
        int i = find(nums, 5);
        System.out.println(i);  //3

        //6、扩容数组 时间复杂度 O(n)
        int[] extend = extend(nums, 2);
    }

    /**
     * 随机访问元素 时间复杂度 O(1)
     */
    public static int randomAccess(int[] nums) {
        //在区间 [0 ~ nums.length) 中随机取一位数字
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        //获取并返回随机元素
        return nums[randomIndex];
    }

    /**
     * 插入元素 时间复杂度 O(n)
     * 需要将该元素之后的所有元素都向后移动一位，之后再把元素赋值给该索引
     */
    public static void insert(int[] nums, int num, int index) {
        //把索引 index 以及之后的所有元素向后移动一位
        //最后一个元素 nums[length-1] 将丢失
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        //将 num 赋给 index 处
        nums[index] = num;
    }

    /**
     * 删除元素 时间复杂度 O(n)
     * 若想删除索引 i 处的元素，则需要把索引 i 之后的元素都向前移动一位
     */
    public static void remove(int[] nums, int index) {
        //把索引 index 之后的元素向前移动
        // nums [nums.length - 1] 会被忽视
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /**
     * 遍历元素 时间复杂度 O(n)
     * 直接通过索引遍历
     */
    public static void traverse(int[] nums) {
        int count = 0;
        // 通过索引遍历
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        // 直接遍历数组
        for (int num : nums) {
            count += num;
        }
    }

    /**
     * 查找元素 时间复杂度 O(n)
     * 遍历查找指定元素对应的索引
     */
    public static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 扩容数组 时间复杂度 O(n)
     * 重新建立一个更大的数组，然后把原数组元素依次复制到新数组
     */
    public static int[] extend(int[] nums, int enlarge) {
        //初始化一个扩展长度后的数组
        int[] res = new int[nums.length + enlarge];
        // 将原数组中的所有元素复制到新数组
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }

        //返回扩展后的数组
        return res;
    }
}

package problems.c0easy.t3501t4000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3606 优惠券校验器 https://leetcode.cn/problems/coupon-code-validator/description/
 * 给你三个长度为 n 的数组，分别描述 n 个优惠券的属性：code、businessLine 和 isActive。其中，第 i 个优惠券具有以下属性：
 * code[i]：一个 字符串，表示优惠券的标识符。
 * businessLine[i]：一个 字符串，表示优惠券所属的业务类别。
 * isActive[i]：一个 布尔值，表示优惠券是否当前有效。
 * 当以下所有条件都满足时，优惠券被认为是 有效的 ：
 * 1、code[i] 不能为空，并且仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）组成。
 * 2、businessLine[i] 必须是以下四个类别之一："electronics"、"grocery"、"pharmacy"、"restaurant"。
 * 3、isActive[i] 为 true 。
 * 返回所有 有效优惠券的标识符 组成的数组，按照以下规则排序：
 * 先按照其 businessLine 的顺序排序："electronics"、"grocery"、"pharmacy"、"restaurant"。
 * 在每个类别内，再按照 标识符的字典序（升序）排序。
 *
 * 示例：
 * 输入1：code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]
 * 输出1：["PHARMA5","SAVE20"]
 *
 * 输入2：code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]
 * 输出2：["ELECTRONICS_50"]
 */
public class T3606 {
    /**
     * 自己实现：根据题意判断模拟
     */
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<String>();
        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            boolean flag = true;
            String s = code[i];
            String b = businessLine[i];
            if (s.isEmpty()) {
                continue;
            }

            // 1、仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）
            for (int j = 0; j < s.length(); j++) {
                if (Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j)) || s.charAt(j) == '_') {
                } else {
                    flag = false;
                }
            }
            // 2、必须是以下四个类别之一："electronics"、"grocery"、"pharmacy"、"restaurant"。
            // 3、isActive[i] 为 true
            if (isActive[i] && flag) {
                if ("electronics".equals(b)) {
                    electronics.add(s);
                }
                if ("grocery".equals(b)) {
                    grocery.add(s);
                }
                if ("pharmacy".equals(b)) {
                    pharmacy.add(s);
                }
                if ("restaurant".equals(b)) {
                    restaurant.add(s);
                }
            }
        }
        Collections.sort(electronics);
        ans.addAll(electronics);
        Collections.sort(grocery);
        ans.addAll(grocery);
        Collections.sort(pharmacy);
        ans.addAll(pharmacy);
        Collections.sort(restaurant);
        ans.addAll(restaurant);
        return ans;
    }

    /**
     * 官方解法：优化写法
     */
    public boolean check(String code, boolean isActive) {
        for (char it : code.toCharArray()) {
            if (it != '_' && !Character.isLetterOrDigit(it)) {
                return false;
            }
        }
        return isActive;
    }
    public List<String> validateCoupons2(String[] code,
                                        String[] businessLine,
                                        boolean[] isActive) {
        List<String>[] groups = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            groups[i] = new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (!code[i].isEmpty() && check(code[i], isActive[i])) {
                if (businessLine[i].equals("electronics")) {
                    groups[0].add(code[i]);
                } else if (businessLine[i].equals("grocery")) {
                    groups[1].add(code[i]);
                } else if (businessLine[i].equals("pharmacy")) {
                    groups[2].add(code[i]);
                } else if (businessLine[i].equals("restaurant")) {
                    groups[3].add(code[i]);
                }
            }
        }
        for (List<String> group : groups) {
            Collections.sort(group);
            ans.addAll(group);
        }
        return ans;
    }
}

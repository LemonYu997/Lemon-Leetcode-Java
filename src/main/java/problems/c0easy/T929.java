package problems.c0easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 929 独特的电子邮件地址 https://leetcode.cn/problems/unique-email-addresses/
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，
 * 以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
 * 例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
 * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），
 * 则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
 * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
 * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。
 * 这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 * 例如 m.y+name@email.com 将转发到 my@email.com。
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。
 * 返回实际收到邮件的不同地址数目。
 */
public class T929 {
    /**
     * 自己实现：使用哈希集合，遇到.跳过，遇到+直接忽略
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            // @后边的可以直接补，@前边的需要判断
            String[] split = email.split("@");
            for (int i = 0; i < split[0].length(); i++) {
                // 遇到 + 直接结束
                if (split[0].charAt(i) == '+') {
                    break;
                }
                // 遇到 . 跳过
                if (split[0].charAt(i) == '.') {
                    continue;
                }
                sb.append(split[0].charAt(i));
            }
            sb.append('@');
            sb.append(split[1]);

            set.add(sb.toString());
            // 清空sb
            sb.setLength(0);
        }
        return set.size();
    }

    /**
     * 官方解法：优化实现
     */
    public int numUniqueEmails1(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf('@');
            // 去掉本地名第一个加号之后的部分
            String local = email.substring(0, i).split("\\+")[0];
            // 去掉本地名中的所有点
            local = local.replace(".", "");
            // 补上 @ 及其之后的部分
            set.add(local + email.substring(i));
        }
        return set.size();
    }
}

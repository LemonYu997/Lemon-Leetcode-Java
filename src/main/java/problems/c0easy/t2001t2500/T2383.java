package problems.c0easy.t2001t2500;

/**
 * 2383 赢得比赛需要的最少训练时长 https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/description/
 * 你正在参加一场比赛，给你两个 正 整数 initialEnergy 和
 * initialExperience 分别表示你的初始精力和初始经验。
 * 另给你两个下标从 0 开始的整数数组 energy 和 experience，长度均为 n 。
 * 你将会 依次 对上 n 个对手。第 i 个对手的精力和经验分别用 energy[i]
 * 和 experience[i] 表示。当你对上对手时，需要在经验和精力上都 严格 超过对手才能击败他们，
 * 然后在可能的情况下继续对上下一个对手。
 * 击败第 i 个对手会使你的经验 增加 experience[i]，但会将你的精力 减少  energy[i] 。
 * 在开始比赛前，你可以训练几个小时。每训练一个小时，你可以选择将增加经验增加 1 或者 将精力增加 1 。
 * 返回击败全部 n 个对手需要训练的 最少 小时数目。
 *
 * 示例：
 * 输入1：initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]
 * 输出1：8
 *
 * 输入2：initialEnergy = 2, initialExperience = 4, energy = [1], experience = [3]
 * 输出2：0
 */
public class T2383 {
    public static void main(String[] args) {
        int[] energy = new int[]{1};
        int[] experience = new int[]{3};
        minNumberOfHours(2, 4, energy, experience);
    }
    /**
     * 自己实现：计算所需精力和所需经验
     */
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 所需额外精力
        int enCount = 0;
        for (int i : energy) {
            enCount += i;
        }
        // 如果当前精力足够应付所有敌人，则不需要训练
        if (initialEnergy > enCount) {
            enCount = 0;
        } else {
            // 要严格超过敌人，所以需要 + 1
            enCount = enCount + 1 - initialEnergy;
        }

        // 所需额外经验
        int exCount = 0;
        for (int i : experience) {
            // 如果当前经验不满足，则需要训练
            if (initialExperience <= i) {
                int temp = i - initialExperience + 1;
                exCount += temp;
                initialExperience += temp;
            }
            // 能够战胜则增加当前经验
            initialExperience += i;
        }

        return enCount + exCount;
    }
}

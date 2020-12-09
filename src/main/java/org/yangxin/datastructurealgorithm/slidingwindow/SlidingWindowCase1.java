package org.yangxin.datastructurealgorithm.slidingwindow;

/**
 * 滑动窗口法的大体框架
 * 1. 我们在字符串S中使用双指针中的左右指针技巧，初始化left=right=0，把索引闭区间[left,right]称为一个“窗口”。
 * 2. 我们先不断地增加right指针扩大窗口[left,right]，直到窗口中的字符串符合要求（包含了T中所有的字符）
 * 3. 此时，我们停止增加right，转而不断增加left指针，缩小窗口[left,right]，直到窗口中的字符串不再符合要求（不包括T中的所有字符了）。
 *  同时，每次增加left，我们都要更新一轮结果。
 * 4. 重复第2和第3步，直到right到达字符串S的尽头。
 *
 * 滑动窗口算法实例1
 *
 * 给定两个长度相同的字符串s和t。
 * 将s中的第i个字符变到t中的第i个字符需要|s[i]-t[i]|的开销（开销可能为0），也就是两个字符的ASCII码值的差的绝对值。
 * 用于变更字符串的最大预算是maxCost。
 * 在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将s的子串转化为它在t中对应的子字符串，则返回可以转化的最大长度。
 * 如果s中没有字符串可以转化成t中对应的子字符串，则返回0。
 *
 * 示例1：
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 *
 * 示例2：
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 *
 * 示例3：
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *
 *
 * @author yangxin
 * 2020/12/09 22:47
 */
public class SlidingWindowCase1 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;

        System.out.println(convertToSubString(s, t, maxCost));
    }

    public static int convertToSubString(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int sum = 0;
        int res = 0;

        // 构造窗口
        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            right++;

            // 窗口构造完成，这时候要根据条件，调整当前窗口的大小
            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            // 记录此时窗口的大小
            res = Math.max(res, right - left);
        }

        System.out.println("left: " + left + " right: " + right);
        System.out.println(s.substring(--left, right));

        return res;
    }
}

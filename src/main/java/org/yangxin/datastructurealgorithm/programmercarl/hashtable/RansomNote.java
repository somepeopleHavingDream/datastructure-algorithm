package org.yangxin.datastructurealgorithm.programmercarl.hashtable;

/**
 * @author yangxin
 * 2022/3/13 18:01
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // 统计magazine串中每个字符出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            count[index]--;

            // 如果值为负数，说明ransomNote字符串中有字符在magazine中不存在
            if (count[index] < 0) {
                return false;
            }
        }

        return true;
    }
}

package org.yangxin.datastructurealgorithm.programmercarl.hashtable;

/**
 * @author yangxin
 * 2022/3/9 22:22
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    private static boolean isAnagram(String s, String t) {
        int[] numArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            numArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            numArray[t.charAt(i) - 'a']--;
        }

        for (int num : numArray) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}

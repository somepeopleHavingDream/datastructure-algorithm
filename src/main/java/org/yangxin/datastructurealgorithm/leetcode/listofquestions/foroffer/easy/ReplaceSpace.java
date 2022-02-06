package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

/**
 * 替换空格
 *
 * @author yangxin
 * 2020/07/24 10:09
 */
public class ReplaceSpace {

    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}

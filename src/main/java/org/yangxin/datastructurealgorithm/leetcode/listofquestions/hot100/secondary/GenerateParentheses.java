package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxin
 * 2022/2/12 14:09
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode", "SameParameterValue"})
public class GenerateParentheses {

    public static void main(String[] args) {
//        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);

        return result;
    }

    private static void generate(List<String> result, String s, int leftCount, int rightCount, int n) {
        if (leftCount > n || rightCount > n) {
            return;
        }

        if (leftCount == n && rightCount == n) {
            result.add(s);
        }

        if (leftCount >= rightCount) {
            generate(result, s + "(", leftCount + 1, rightCount, n);
            generate(result, s + ")", leftCount, rightCount + 1, n);
        }
    }
}

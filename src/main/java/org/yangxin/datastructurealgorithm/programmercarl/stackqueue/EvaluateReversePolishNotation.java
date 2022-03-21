package org.yangxin.datastructurealgorithm.programmercarl.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author yangxin
 * 2022/3/21 21:56
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRpn(tokens));
    }

    private static int evalRpn(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            // 如果当前记号不是运算符，则入栈
            if (!Objects.equals(token, "+")
                    && !Objects.equals(token, "-")
                    && !Objects.equals(token, "*")
                    && !Objects.equals(token, "/")) {
                stack.push(Integer.valueOf(token));
            } else {
                // 当前记号是运算符，则弹出两个元素，与当前运算符做运算，然后将结果压入栈中
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        break;
                }
            }
        }

        return stack.pop();
    }
}

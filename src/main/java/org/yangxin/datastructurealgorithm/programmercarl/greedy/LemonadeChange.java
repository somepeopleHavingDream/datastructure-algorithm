package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/11 17:17
 */
public class LemonadeChange {

    public static void main(String[] args) {
//        int[] bills = {5, 5, 5, 10, 20};
        int[] bills = {5, 5, 10, 10, 20};

        System.out.println(lemonadeChange(bills));
    }

    private static boolean lemonadeChange(int[] bills) {
        int fiveNum = 0, tenNum = 0;
        for (int bill : bills) {
            // 如果是5元
            if (bill == 5) {
                fiveNum++;
                continue;
            }

            // 如果是10元
            if (bill == 10) {
                if (fiveNum <= 0) {
                    return false;
                }
                fiveNum--;
                tenNum++;
                continue;
            }

            // 如果是20元
            if (bill == 20) {
                if (tenNum > 0 && fiveNum > 0) {
                    tenNum--;
                    fiveNum--;
                } else if (tenNum <= 0 && fiveNum >= 3) {
                    fiveNum -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

package org.yangxin.datastructurealgorithm.programmercarl.array;

/**
 * @author yangxin
 * 2022/3/3 21:29
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
//        int[] fruits = {0, 1, 2, 2};
//        int[] fruits = {1, 2, 3, 2, 2};

        // 5
//        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        // 4
//        int[] fruits = {5, 1, 4, 1, 4, 2};

        // 5
//        int[] fruits = {0, 1, 6, 6, 4, 4, 6};

        // 5
//        int[] fruits = {1, 0, 1, 4, 1, 4, 1, 2, 3};

        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        int max = Integer.MIN_VALUE;

        int i, j = 0, count = 0;
        int left = fruits[0], right = -1;
        for (; j < fruits.length; j++) {
            if (right == -1 &&  fruits[j] != left) {
                right = fruits[j];
            }

            if (fruits[j] != left && fruits[j] != right) {
                left = fruits[j - 1];
                right = fruits[j];

                i = j - 1;
                count = 2;
                while (fruits[i - 1] == left) {
                    i--;
                    count++;
                }
                continue;
            }

            max = Math.max(max, ++count);
        }

        return max;
    }
}

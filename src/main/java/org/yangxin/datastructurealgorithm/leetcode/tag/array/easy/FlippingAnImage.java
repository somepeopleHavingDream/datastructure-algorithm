package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/3/21 下午5:41
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class FlippingAnImage {

    public static int[][] flipAndInvertImage(int[][] image) {
        if (image == null) {
            return new int[0][];
        }

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < (image[i].length + 1)/ 2; j++) {
                int tmp1 = image[i][j] == 0 ? 1 : 0;
                int tmp2 = image[i][image[i].length - j - 1] == 0 ? 1 : 0;
                image[i][j] = tmp2;
                image[i][image[i].length - j - 1] = tmp1;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image1 = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image1)));

        int[][] image2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image2)));
    }
}

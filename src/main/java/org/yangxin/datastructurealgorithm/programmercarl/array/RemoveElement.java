package org.yangxin.datastructurealgorithm.programmercarl.array;

/**
 * @author yangxin
 * 2022/3/2 21:38
 */
@SuppressWarnings("SameParameterValue")
public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println(removeElement(nums, 2));
    }

    private static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}

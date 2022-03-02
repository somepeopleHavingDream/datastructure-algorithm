package org.yangxin.datastructurealgorithm.programmercarl.array;

/**
 * @author yangxin
 * 2022/3/2 20:45
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode", "SameParameterValue"})
public class BinarySearch {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 3, 5, 9, 12};
//        System.out.println(search(nums, 9));

        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 2));
    }

    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

package org.yangxin.datastructurealgorithm.programmercarl.array;

/**
 * @author yangxin
 * 2022/3/2 21:07
 */
@SuppressWarnings("SameParameterValue")
public class SearchInsertPosition {

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
        int[] nums = {1};

        System.out.println(searchInsert(nums, 1));
    }

    private static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 看目标值是否在范围之外
        if (target < nums[left]) {
            return 0;
        }
        if (target > nums[right]) {
            return right + 1;
        }

        // 否则就在范围内
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

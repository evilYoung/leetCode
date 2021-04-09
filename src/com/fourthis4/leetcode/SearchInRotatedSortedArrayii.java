package com.fourthis4.leetcode;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInRotatedSortedArrayii {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        return subSearch(nums, left, right, target);
    }

    private boolean subSearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target
                    || nums[left] == target
                    || nums[right] == target) {
                return true;
            }

            if (nums[left] == nums[right] && nums[right] == nums[mid]) {
                return subSearch(nums, left, mid - 1, target) || subSearch(nums, mid + 1, right, target);
            }

            if (nums[left] < nums[right]){
                if (nums[mid] > target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] > target) {
                    if (nums[mid] > nums[right]) {
                        if (nums[left] > target) {
                            left = mid + 1;
                        } else if (nums[left] < target) {
                            right = mid - 1;
                        } else {
                            return true;
                        }
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (nums[mid] > nums[right]){
                        left = mid + 1;
                    } else {
                        return subSearch(nums, left, mid - 1, target) || subSearch(nums, mid + 1, right, target);
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayii obj = new SearchInRotatedSortedArrayii();

        int[] nums = new int[]{3,3,0,1,3};
//        int[] nums = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(obj.search(nums, 1));
    }
}

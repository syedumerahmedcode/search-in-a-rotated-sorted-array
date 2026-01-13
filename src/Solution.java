public class Solution {

    public int search(int[] nums, int target) {
        /**
         * Defining variables
         */

        int left = 0;
        int right = nums.length - 1;

        /**
         * While left <= right
         */
        while (left <= right) {
            /**
             * Calculate mid pointer
             */
            int mid = (left + right) / 2;
            /**
             * If mid == target, return the index of mid
             */
            if (nums[mid] == target) {
                return mid;
            }
            /**
             * figure out which part from mid to (left/right) pointer is completely sorted
             */
            if (nums[left] <= nums[mid]) {
                /**
                 * Check if the target lies outside left and mid pointer range.
                 */
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}

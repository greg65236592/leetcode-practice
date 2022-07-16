package leetcode.practice;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 *
 * <p>Given an integer array nums of length n and an integer target, find three integers in nums
 * such that the sum is closest to target.
 *
 * <p>Return the sum of the three integers.
 *
 * <p>You may assume that each input would have exactly one solution.
 *
 * <pre>
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </pre>
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int nearestTarget = Integer.MAX_VALUE;
    for (int current = 0; current < nums.length - 2; current++) {
      System.out.println("======" + current + "======");
      int left = current + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[current] + nums[left] + nums[right];
        System.out.println("current: " + current + " left: " + left + " right: " + right);
        System.out.println("sum: " + sum);
        System.out.println("current: " + nums[current]);
        System.out.println("left: " + nums[left]);
        System.out.println("right: " + nums[right]);
        System.out.println(
            "sum - target: " + Math.abs(sum - target) + "; nearestTarget: " + nearestTarget);
        if (Math.abs(sum - target) < Math.abs(nearestTarget - target)) {
          nearestTarget = sum;
        }
        if (sum > target) {
          right--;
        } else {
          left++;
        }
      }
    }
    return nearestTarget;
  }
}

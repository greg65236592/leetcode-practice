package leetcode.practice;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 * <p>Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i
 * != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * <p>Notice that the solution set must not contain duplicate triplets.
 *
 * <pre>
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * </pre>
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return Collections.emptyList();
    }
    var list = new LinkedList<List<Integer>>();
    Arrays.sort(nums);
    //    System.out.println(Arrays.toString(nums));

    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i - 1] == nums[i]) { // skip duplicate set
        continue;
      }
      var currVal = nums[i];
      var leftCursor = i + 1;
      var rightCursor = nums.length - 1;
      var target = -nums[i];
      while (leftCursor < rightCursor) {
        //                System.out.println("checkpoint " + i + ":" + leftCursor + ":" +
        // rightCursor);
        if ((nums[leftCursor] > 0 && target <= 0)
            || (nums[rightCursor] < 0 && target >= 0)) { // some optimize at 2nd lv
          break;
        }
        if (nums[leftCursor] + nums[rightCursor] == target) {
          //          System.out.println("IN");
          list.add(List.of(currVal, nums[leftCursor], nums[rightCursor]));
          // cannot skip the first one, but following ones
          while (leftCursor < rightCursor - 1 && nums[leftCursor] == nums[leftCursor + 1])
            leftCursor++;
          while (leftCursor < rightCursor - 1 && nums[rightCursor] == nums[rightCursor - 1])
            rightCursor--;
          leftCursor++;
          rightCursor--;
        } else if (nums[leftCursor] + nums[rightCursor] < target) {
          leftCursor++;
        } else {
          rightCursor--;
        }
      }
    }
    return list;
  }
}

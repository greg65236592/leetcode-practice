package leetcode.practice;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/two-sum/
 *
 * <pre>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * </pre>
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    // Use map as extra space to prevent second iteration
    Map<Integer, Integer> valIdxMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      valIdxMap.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int firstVal = nums[i];
      int expectSecondVal = target - firstVal;
      Integer expectSecondIdx = valIdxMap.get(expectSecondVal);
      if (expectSecondIdx != null && expectSecondIdx != i /*exclude self*/) {
        return new int[] {i, expectSecondIdx};
      }
    }
    return null;
  }
}

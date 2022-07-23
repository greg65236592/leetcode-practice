package leetcode.practice;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * <pre>
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * </pre>
 */
public class FindTheDuplicateNumber {

  public int findDuplicate(int[] nums) {
    var slow = 0;
    var fast = 0;
    // 1st intersection
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];

    } while (slow != fast);
    // 2nd intersection
    var start = 0;
    do {
      start = nums[start];
      slow = nums[slow];
    } while (start != slow);
    return slow;
  }
}

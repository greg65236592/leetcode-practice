package leetcode.practice;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * <pre>
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2 Output: 5
 * </pre>
 */
public class KthLargestElement {

  private int sortAfter = 0; // skipping unnecessary recursive calls by skipping partitions
  private int[] nums;

  public int findKthLargest(int[] nums, int k) {
    sortAfter = nums.length - k;
    this.nums = nums;
    sort(0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
    return nums[nums.length - k];
  }

  public void sort(int start, int end) {
    if (start == end) return;
    int i = start - 1;
    int j = start;
    int pivot = nums[end];
    while (true) {
      if (j == end) {
        swap(i + 1, end);
        if (start <= i && i >= sortAfter) {
          sort(start, i);
        }
        if (i + 2 <= end && end >= sortAfter) {
          sort(i + 2, end);
        }
        break;
      }
      if (i == j) {
        j++;
      } else if (nums[j] <= pivot) {
        i++;
        swap(i, j);
      } else if (nums[j] > pivot) {
        j++;
      }
    }
  }

  private void swap(int x, int y) {
    var xTmp = nums[x];
    nums[x] = nums[y];
    nums[y] = xTmp;
  }
}

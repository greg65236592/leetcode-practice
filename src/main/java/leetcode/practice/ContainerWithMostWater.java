package leetcode.practice;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * <pre>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * </pre>
 */
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxLeft = height[left];
    int maxRight = height[right];
    int maxArea = Math.min(maxLeft, maxRight) * (height.length - 1);
    while (right != left) {
      if (maxLeft > maxRight) {
        right--;
      } else {
        left++;
      }
      if (maxRight < height[right]) {
        maxRight = height[right];
        maxArea = Math.max(maxArea, Math.min(maxLeft, maxRight) * (right - left));
      } else if (maxLeft < height[left]) {
        maxLeft = height[left];
        maxArea = Math.max(maxArea, Math.min(maxLeft, maxRight) * (right - left));
      }
    }
    return maxArea;
  }
}

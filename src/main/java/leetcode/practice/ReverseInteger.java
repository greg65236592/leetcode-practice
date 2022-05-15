package leetcode.practice;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * <p>Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * <pre>
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * </pre>
 */
public class ReverseInteger {

  public int reverse(int x) {
    var result = 0;
    if (x / 10 == 0) {
      return x;
    }
    while (x != 0) {
      try {
        result = Math.multiplyExact(result, 10);
        result = Math.addExact(result, x % 10);
      } catch (ArithmeticException e) {
        return 0;
      }
      x = x / 10;
    }
    return result;
  }
}

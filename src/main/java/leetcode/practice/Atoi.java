package leetcode.practice;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * <pre>
 * Example 2:
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 *
 * Example 3:
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 * </pre>
 *
 * Notes:
 *
 * <pre>
 * No StringBuilder, use int.
 * No set of numbers, use range: '0' <= x <= '9'
 * Char to int value conversion: Character.getNumericValue(...) or ch - '0'
 * </pre>
 */
public class Atoi {

  public int myAtoi(String str) {
    var result = 0;
    var isStart = false;
    var isNegative = false;
    int cursor = 0;
    while (cursor < str.length()) {
      var ch = str.charAt(cursor);
      if (!isStart && (ch == '-' || ch == '+')) {
        if (ch == '-') {
          isNegative = true;
        }
        isStart = true;
      } else if (isDigit(ch)) {
        try {
          result = Math.addExact(Math.multiplyExact(result, 10), ch - '0');
          if (!isStart) {
            isStart = true;
          }
        } catch (ArithmeticException e) {
          if (isNegative) {
            return Integer.MIN_VALUE;
          }
          return Integer.MAX_VALUE;
        }
      } else if (!isStart && ch == ' ') {
        // do nothing
      } else {
        break;
      }
      cursor++;
    }
    if (isNegative) {
      try {
        result = Math.multiplyExact(result, -1);
      } catch (ArithmeticException e) {
        return Integer.MIN_VALUE;
      }
    }
    return result;
  }

  private boolean isDigit(char ch) {
    return ch >= '0' && ch <= '9';
  }
}

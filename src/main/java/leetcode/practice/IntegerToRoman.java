package leetcode.practice;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * <pre>
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </pre>
 */
public class IntegerToRoman {

  public String intToRoman(int num) {
    var strBuilder = new StringBuilder();
    var arr = String.valueOf(num).toCharArray();
    var cursor = 0;
    if (arr.length == 4) {
      var val = arr[cursor] - '0';
      strBuilder.append("M".repeat(val));
      cursor++;
    }
    if (arr.length >= 3) {
      var val = arr[cursor] - '0';
      if (val == 9) {
        strBuilder.append('C').append('M');
      } else if (val == 4) {
        strBuilder.append('C').append('D');
      } else if (val >= 5) {
        strBuilder.append('D').append("C".repeat(val - 5));
      } else {
        strBuilder.append("C".repeat(val));
      }
      cursor++;
    }
    if (arr.length >= 2) {
      var val = arr[cursor] - '0';
      if (val == 9) {
        strBuilder.append('X').append('C');
      } else if (val == 4) {
        strBuilder.append('X').append('L');
      } else if (val >= 5) {
        strBuilder.append('L').append("X".repeat(val - 5));
      } else {
        strBuilder.append("X".repeat(val));
      }
      cursor++;
    }
    if (arr.length >= 1) {
      var val = arr[cursor] - '0';
      if (val == 9) {
        strBuilder.append('I').append('X');
      } else if (val == 4) {
        strBuilder.append('I').append('V');
      } else if (val >= 5) {
        strBuilder.append('V').append("I".repeat(val - 5));
      } else {
        strBuilder.append("I".repeat(val));
      }
    }
    return strBuilder.toString();
  }
}

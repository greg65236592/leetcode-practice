package leetcode.practice;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * <pre>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * </pre>
 */
public class ZigzagConversion {

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    boolean isOrderUp = true;
    char[] arr = s.toCharArray();
    var rowToSubStr = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      rowToSubStr[i] = new StringBuilder();
    }
    int idx = 0;
    int rowToWrite = 0;
    while (idx < arr.length) {
      int finalIdx = idx;
      rowToSubStr[rowToWrite].append(arr[finalIdx]);
      idx++;
      if (idx == 1) { // first don't
        rowToWrite++;
        continue;
      }
      if (rowToWrite == 0 || rowToWrite == numRows - 1) {
        isOrderUp = !isOrderUp;
      }
      if (isOrderUp) {
        rowToWrite++;
      } else {
        rowToWrite--;
      }
    }
    return String.join("", rowToSubStr);
  }
}

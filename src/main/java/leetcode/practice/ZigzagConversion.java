package leetcode.practice;

import java.util.HashMap;

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
    var rowToSubStr = new HashMap<Integer, StringBuilder>();
    int idx = 0;
    int rowToWrite = 0;
    while (idx < arr.length) {
      int finalIdx = idx;
      rowToSubStr.compute(
          rowToWrite,
          (k, v) -> {
            if (v == null) {
              v = new StringBuilder().append(arr[finalIdx]);
            } else {
              v.append(arr[finalIdx]);
            }
            return v;
          });
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
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      if (rowToSubStr.get(i) != null) {
        result.append(rowToSubStr.get(i));
      }
    }
    return result.toString();
  }
}

package leetcode.practice;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */
public class LongestPalindrome {

  // search nearby
  public String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    int idx = 0;
    int max = 0;
    int mostLeft = 0;
    int mostRight = 0;
    while (idx < chars.length) {
      //            if (mostRight > idx) { // skip previous [Notice: we can not skip since
      // palindrome strings may overlay]
      //                idx = mostRight;
      //            }
      if (idx > 0) { // (aba)
        int left = idx;
        int right = idx;
        while (true) {
          if (left > 0 && right + 1 < chars.length && chars[left - 1] == chars[right + 1]) {
            left--;
            right++;
          } else {
            if (right - left > max) {
              max = right - left;
              mostLeft = left;
              mostRight = right;
            }
            break;
          }
        }
      }
      if (idx > 0 && chars[idx] == chars[idx - 1]) { // (abba)
        int left = idx - 1;
        int right = idx;
        while (true) {
          if (left > 0 && right + 1 < chars.length && chars[left - 1] == chars[right + 1]) {
            left--;
            right++;
          } else {
            if (right - left > max) {
              max = right - left;
              mostLeft = left;
              mostRight = right;
            }
            break;
          }
        }
      }
      idx++;
    }
    return String.copyValueOf(Arrays.copyOfRange(chars, mostLeft, mostRight + 1));
  }

  public String longestPalindromeWithManacher(String s) {
    // create Manacher string
    var delimiter = '#';
    char[] chars = s.toCharArray();
    var manacherChars = new char[2 * chars.length + 1];
    var radiusStorage = new int[2 * chars.length + 1];
    manacherChars[0] = delimiter;
    var idx = 1;
    for (char c : chars) {
      manacherChars[idx] = c;
      idx++;
      manacherChars[idx] = delimiter;
      idx++;
    }

    var center = 0;
    var maxRadius = 0;
    var maxCenter = 0;
    while (center < manacherChars.length) {
      var radius = 0;
      while (center - radius - 1 >= 0
          && center + radius + 1 < manacherChars.length
          && manacherChars[center - radius - 1] == manacherChars[center + radius + 1]) {
        radius++;
      }
      radiusStorage[center] = radius;
      if (radius > maxRadius) {
        maxRadius = radius;
        maxCenter = center;
      }

      int nextCenterBoundary = center + radius;
      int newCenter = center + 1;
      // notice, we can reuse previous result and skip calculation here.
      while (newCenter <= nextCenterBoundary && newCenter < manacherChars.length) {
        int mirroredCenter = center - (newCenter - center);
        int mirroredRadius = radiusStorage[mirroredCenter];
        if (newCenter + mirroredRadius > nextCenterBoundary) {
          radiusStorage[newCenter] = nextCenterBoundary - newCenter;
          newCenter++;
        } else if (newCenter + mirroredRadius < nextCenterBoundary) {
          radiusStorage[newCenter] = mirroredRadius;
          newCenter++;
        } else { // newCenter + mirroredRadius == nextCenterBoundary
          break;
        }
      }
      center = newCenter;
    }
    // build sub array in primitive way
    int start = maxCenter - maxRadius;
    int end = maxCenter + maxRadius;
    int i = 0;
    int j = 0;
    int length = ((end + 1 - start) - 1) / 2;
    char[] result = new char[length];
    while (i < manacherChars.length) {
      if ('#' != manacherChars[i] && i >= start && i <= end) {
        result[j] = manacherChars[i];
        j++;
      }
      i++;
    }
    return String.valueOf(result);
  }
}

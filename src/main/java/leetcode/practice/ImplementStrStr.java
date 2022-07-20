package leetcode.practice;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * <pre>
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 * </pre>
 */
public class ImplementStrStr {

  public int strStr(String haystack, String needle) {
    var haystackChs = haystack.toCharArray();
    var needleChs = needle.toCharArray();

    for (int left = 0; left < haystackChs.length; left++) {
      var needleIdx = 0;
      while (needleIdx < needleChs.length
          && left + needleIdx < haystackChs.length
          && haystackChs[left + needleIdx] == needleChs[needleIdx]) {
        needleIdx++;
      }
      if (needleIdx == needleChs.length) {
        return left;
      }
    }

    return -1;
  }
}

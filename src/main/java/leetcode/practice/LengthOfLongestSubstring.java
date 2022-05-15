package leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LengthOfLongestSubstring {

  /** Calculate with two sliding windows */
  public int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();

    int max = 0;
    int latestCursor1 = 0;
    int latestCursor2 = 0;

    int charsLength = chars.length;
    Map<Character, Integer> occurrence = new HashMap<>();

    for (int i = 0; i < charsLength; i++) {
      char c = chars[i];

      Integer current1 = occurrence.get(c);
      int current2 = i;
      boolean isWindowClose = current1 != null;
      int subStrLength;
      if (isWindowClose) {
        if (latestCursor1 == 0 && latestCursor2 == 0) { // first close
          // renew last
          latestCursor2 = current2;
          subStrLength = latestCursor2 - latestCursor1;
          latestCursor1 = current1;
        } else if (current1 <= latestCursor1 && current2 > latestCursor2) { // full overlap
          // renew last
          subStrLength = current2 - latestCursor1;
          latestCursor2 = current2;
        } else if (current1 > latestCursor1 && current1 < latestCursor2) { // partial overlap
          subStrLength = current2 - (latestCursor1 + 1);
          // renew last
          latestCursor1 = current1;
          latestCursor2 = current2;
        } else { // no overlap
          subStrLength = current2 - (latestCursor1 + 1);
          // renew last
          latestCursor1 = current1;
          latestCursor2 = current2;
        }

        // check and renew max
        if (max < subStrLength) {
          max = subStrLength;
        }
      } else if (i == charsLength - 1) { // last but not closed
        subStrLength = i - latestCursor1;
        // check and renew max
        if (max < subStrLength) {
          max = subStrLength;
        }
      }
      occurrence.put(c, i);
    }

    if (latestCursor1 == 0 && latestCursor2 == 0) { // never closed
      max = charsLength;
    }
    return max;
  }

  /** As deque poll first */
  public int lengthOfLongestSubstringWithDeque(String s) {
    char[] chars = s.toCharArray();
    Set<Character> exitedChars = new HashSet<>();
    int max = 0;
    int headIdx = 0;
    int tailIdx = 0;
    while (tailIdx < chars.length) {
      if (exitedChars.contains(chars[tailIdx])) {
        exitedChars.remove(chars[headIdx]);
        headIdx++;
      } else {
        exitedChars.add(chars[tailIdx]);
        max = Math.max(max, exitedChars.size());
        tailIdx++;
      }
    }
    return max;
  }
}

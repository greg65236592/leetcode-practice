package leetcode.practice;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * <p>Given an integer n, return the number of structurally unique BST's (binary search trees) which
 * has exactly n nodes of unique values from 1 to n.
 *
 * <p>Input: n = 3 Output: 5
 *
 * <p>Constraints:
 *
 * <p>1 <= n <= 19
 *
 * <p>Solution provided by: liaison
 * https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
 * G(n) = F(1, n) + F(2, n) + ... + F(n, n).
 */
public class UniqueBinarySearchTrees {

  public int numTrees(int n) {
    var G = new int[n + 1];
    G[0] = 1;
    G[1] = 1;
    if (n == 1) return 1;
    for (int i = 2; i <= n; i++) {
      System.out.println("===" + i + "===");
      for (int j = 0; j <= i - 1; j++) {
        System.out.println(i + " " + j + "," + (i - j - 1));
        G[i] += G[j] * G[i - j - 1];
        System.out.println(G[i] + "=" + G[j] + "*" + G[i - j]);
        System.out.println("-------");
      }
      System.out.println(Arrays.toString(G));
    }
    return G[n];
  }

  public static void main(String[] args) {
    var result = new UniqueBinarySearchTrees().numTrees(4);
    System.out.println(result);
  }
}

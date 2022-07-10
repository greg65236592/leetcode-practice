package leetcode.practice;

/**
 * https://leetcode.com/problems/gas-station/
 *
 * <pre>
 * Example 1:
 *
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 *
 * Constraints:
 *
 * n == gas.length == cost.length
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 * </pre>
 */
public class GasStation {

  public int canCompleteCircuitV2(int[] gas, int[] cost) {
    int totalGasToFinish = 0;
    int tank = 0;
    int res = 0;
    for (int i = 0; i < gas.length; i++) {
      totalGasToFinish += gas[i] - cost[i];
      tank += gas[i] - cost[i];
      if (tank < 0) {
        res = i + 1;
        tank = 0;
      }
    }
    if (totalGasToFinish < 0) {
      return -1;
    } else {
      return res;
    }
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int left = 0;
    int right = 0;
    int totalGas = gas[0];
    do {
      // get next right
      var nextRight = right + 1;
      if (nextRight >= gas.length) {
        nextRight = nextRight - gas.length;
      }
      if (totalGas - cost[right] >= 0) {
        totalGas += gas[nextRight] - cost[right];
        right = nextRight;
        System.out.println("forward:" + right + " gas:" + totalGas);
      } else {
        System.out.println("skipping... total gas: " + totalGas + ", next cost: " + cost[right]);
        // get next left
        var nextLeft = left - 1;
        if (nextLeft < 0) {
          nextLeft = nextLeft + gas.length;
        }
        // if next left will contact right, check the availability
        if (nextLeft == right && totalGas - cost[right] < 0) {
          System.out.println("NOT AVAILABLE");
          return -1;
        }
        totalGas += gas[nextLeft] - cost[nextLeft];
        left = nextLeft;
        System.out.println("backward:" + left + " gas:" + totalGas);
      }
    } while (left != right);
    if (totalGas > 0) {
      System.out.println(left);
      return left;
    } else {
      System.out.println(-1);
      return -1;
    }
  }
}

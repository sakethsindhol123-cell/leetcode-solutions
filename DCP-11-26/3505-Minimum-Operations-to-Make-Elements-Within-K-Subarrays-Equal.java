
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int ls = 0, hs = 0;
    long sumL = 0, sumR = 0;

    void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int val) {
        int c = map.get(val);
        if (c == 1) map.remove(val);
        else map.put(val, c - 1);
    }

    void insert(int val) {
        if (low.isEmpty() || val <= low.lastKey()) {
            add(low, val);
            ls++;
            sumL += val;
        } else {
            add(high, val);
            hs++;
            sumR += val;
        }
        balance();
    }

    void erase(int val) {
        if (low.containsKey(val)) {
            remove(low, val);
            ls--;
            sumL -= val;
        } else {
            remove(high, val);
            hs--;
            sumR -= val;
        }
        balance();
    }

    void balance() {
        while (ls > hs + 1) {
            int v = low.lastKey();
            remove(low, v);
            add(high, v);
            ls--;
            hs++;
            sumL -= v;
            sumR += v;
        }

        while (ls < hs) {
            int v = high.firstKey();
            remove(high, v);
            add(low, v);
            hs--;
            ls++;
            sumR -= v;
            sumL += v;
        }
    }

    long getCost() {
        long m = low.lastKey();

        return m * ls - sumL + sumR - m * hs;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++)
            insert(nums[i]);

        cost[0] = getCost();

        for (int i = x; i < n; i++) {
            erase(nums[i - x]);
            insert(nums[i]);

            cost[i - x + 1] = getCost();
        }

        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[k + 1][n + 1];

        for (long[] row : dp)
            Arrays.fill(row, INF);

        Arrays.fill(dp[0], 0);

        for (int t = 0; t < k; t++) {
            for (int i = 0; i < n; i++) {

                if (dp[t][i] == INF)
                    continue;

                dp[t][i + 1] = Math.min(
                    dp[t][i + 1], dp[t][i]
                );

                if (i + x <= n) {
                    dp[t + 1][i + x] = Math.min(
                        dp[t + 1][i + x],
                        dp[t][i] + cost[i]
                    );
                }
            }
        }

        for (int i = 1; i <= n; i++)
            dp[k][i] = Math.min(dp[k][i], dp[k][i - 1]);

        return dp[k][n];
    }
}

class Solution {
    long MOD = 1_000_000_007L;
    long[] sum, sq, lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        java.util.Map<Integer, Integer> last = new java.util.HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = last.getOrDefault(nums[i], -1) + 1;
            update(1, 0, n - 1, l, i);

            ans = (ans + sq[1]) % MOD;
            last.put(nums[i], i);
        }

        return (int) ans;
    }

    void update(int node, int start, int end, int l, int r) {
        if (l > end || r < start) return;

        if (l <= start && end <= r) {
            apply(node, start, end, 1);
            return;
        }

        push(node, start, end);

        int mid = (start + end) / 2;
        update(node * 2, start, mid, l, r);
        update(node * 2 + 1, mid + 1, end, l, r);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    void apply(int node, int start, int end, long val) {
        long len = end - start + 1;

        sq[node] = (sq[node] + 2 * val * sum[node]
                    + val * val % MOD * len) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) return;

        int mid = (start + end) / 2;

        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }
}
class Solution {
    public int sortableIntegers(int[] nums) {
        int[] qelvarodin = nums.clone();
        int n = qelvarodin.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            int prev = Integer.MIN_VALUE;
            boolean ok = true;

            for (int i = 0; i < n; i += k) {
                int desc = 0, start = 0;

                for (int j = 0; j < k; j++) {
                    int a = qelvarodin[i + j];
                    int b = qelvarodin[i + (j + 1) % k];

                    if (a > b) {
                        desc++;
                        start = (j + 1) % k;
                    }
                }

                if (desc > 1) {
                    ok = false;
                    break;
                }

                int first = qelvarodin[i + start];
                int last = qelvarodin[i + (start + k - 1) % k];

                if (prev > first) {
                    ok = false;
                    break;
                }

                prev = last;
            }

            if (ok) ans += k;
        }

        return ans;
    }
}
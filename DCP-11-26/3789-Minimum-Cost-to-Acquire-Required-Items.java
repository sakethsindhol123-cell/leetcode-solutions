
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        long ans1 = (long) need1 * cost1 + (long) need2 * cost2;

        long ans2 = (long) Math.max(need1, need2) * costBoth;

        long common = Math.min(need1, need2);

        long ans3 = common * costBoth
                  + (long) (need1 - common) * cost1
                  + (long) (need2 - common) * cost2;

        return Math.min(ans1, Math.min(ans2, ans3));
    }
}


import java.util.*;

class Solution {
    List<Integer>[] tree;
    List<Integer>[] newTree;
    int[] last;
    int[] ans;
    String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;

        tree = new ArrayList[n];
        newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        last = new int[26];
        Arrays.fill(last, -1);

        // Find new parents
        dfs1(0, -1);

        // Calculate subtree sizes
        ans = new int[n];
        dfs2(0);

        return ans;
    }

    void dfs1(int u, int p) {
        int c = s.charAt(u) - 'a';

        int old = last[c];

        int newParent = (old == -1) ? p : old;

        if (u != 0) {
            newTree[newParent].add(u);
        }

        last[c] = u;

        for (int v : tree[u]) {
            dfs1(v, u);
        }

        last[c] = old;
    }

    int dfs2(int u) {
        ans[u] = 1;

        for (int v : newTree[u]) {
            ans[u] += dfs2(v);
        }

        return ans[u];
    }
}
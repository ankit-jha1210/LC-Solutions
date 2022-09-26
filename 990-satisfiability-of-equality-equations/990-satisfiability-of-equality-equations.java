class Solution {

    public boolean equationsPossible(String[] equations) {
        int[] rank = new int[26];
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a', rank, parent);
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (findPar(s.charAt(0) - 'a', parent) == findPar(s.charAt(3) - 'a', parent)) return false;
            }
        }
        return true;
    }

    int findPar(int u, int[] parent) {
        if (parent[u] == u) return u;
        return parent[u] = findPar(parent[u], parent);
    }

    void union(int u, int v, int[] rank, int[] parent) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[u] > rank[v]) {
            parent[v] = u;
        } else if (rank[v] > rank[u]) {
            parent[u] = v;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }
}

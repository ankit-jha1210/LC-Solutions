class Node {
    private Node[] links;
    public Node() {
        links = new Node[2];
    }
    
    public boolean containsKey(int bit) {
        return links[bit] != null;
    }
    public Node get(int bit) {
        return links[bit];
    }
    public void put(int bit) {
        links[bit] = new Node();
    }
    
}

class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(int num) {
        Node node = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit);
            }
            node = node.get(bit);
        }
    }
    
    public int getMax(int x) {
        int maxNum = 0;
        Node node = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            if(node.containsKey(1 - bit)) {
                maxNum  = maxNum | (1 << i);
                node = node.get(1 - bit);
            }
            else node = node.get(bit);
            
        }
        
        return maxNum;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        Arrays.sort(nums);
        List<int[]> offQ = new ArrayList<>();
        int q = queries.length;
        for(int i = 0;i<q;i++){
            offQ.add(new int[]{i, queries[i][0], queries[i][1]});
        }
        Collections.sort(offQ, (a, b) -> a[2] - b[2]);
        int[] res = new int[q];
        int ind = 0;
        for(int i = 0;i<q;i++) {
            int qi = offQ.get(i)[0];
            int x = offQ.get(i)[1];
            int ai = offQ.get(i)[2];
            while(ind < nums.length) {
                if(nums[ind] <= ai) {
                    trie.insert(nums[ind++]);
                }
                else break;
            }
            if(ind == 0) res[qi] = -1;
            else res[qi] = trie.getMax(x);
        }
        return res;
    }
}
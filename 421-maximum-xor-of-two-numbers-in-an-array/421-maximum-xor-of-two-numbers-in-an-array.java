class Node {
    Node[] links;

    Node() {
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
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit);
            }
            node = node.get(bit);
        }
    }

    public int getMax(int x) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, trie.getMax(x));
        }
        return max;
    }
}

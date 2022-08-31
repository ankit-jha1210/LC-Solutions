class Node {
    private Node[] links;
    private int childCount;
    boolean isTerminating;

    public Node() {
        links = new Node[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch) {
        links[ch - 'a'] = new Node();
    }

    public void increaseChildCount() {
        childCount++;
    }

    public int getChildCount() {
        return childCount;
    }
}

class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch);
                node.increaseChildCount();
            }
            node = node.get(ch);
        }
        node.isTerminating = true;
    }

    public String getLCP(String str) {
        Node node = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (node.getChildCount() == 1) {
                node = node.get(ch);
                sb.append(ch);
            } else break;
            if (node.isTerminating) break;
        }
        return sb.toString();
    }
}

class Solution {

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String s : strs) {
            if (s.equals("")) return "";
            trie.insert(s);
        }

        return trie.getLCP(strs[0]);
    }
}

class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return helper(root, new int[10]);
    }
    int helper(TreeNode root, int[] freq) {
        if(root == null) return 0;
        freq[root.val]++;
        if(root.left == null && root.right == null) {
            int ans = isPalindrome(freq);
            freq[root.val]--;
            return ans;
        }
        int ans = helper(root.left, freq) + helper(root.right, freq);
        freq[root.val]--;
        return ans;
    }
    int isPalindrome(int[] freq) {
        int cnt = 0;
        for(int i: freq) {
            if(i % 2 == 1) {
                cnt++;
                if(cnt > 1) return 0;
            }
        }
        return 1;
    }
}
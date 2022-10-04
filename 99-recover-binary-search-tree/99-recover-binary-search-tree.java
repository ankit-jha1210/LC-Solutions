class Solution {
    //  brute force we are just sorting the array and comparing with tree
    int i = 0;
    public void recoverTree(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inorder(root, lst);
        Collections.sort(lst);
        check(root, lst);
    }
    void inorder(TreeNode root, List<Integer> lst) {
        if(root == null) return;
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }
    void check(TreeNode root, List<Integer> lst) {
        if(root == null) return;
        check(root.left, lst);
        if(root.val != lst.get(i)) {
            root.val = lst.get(i);
        }
        i++;
        check(root.right, lst);
        
        
    }
}
class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) map.put(nums1[i], i);
        int[] nge = new int[nums1.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() < nums2[i]) stk.pop();
            if (map.containsKey(nums2[i])) {
                int idx = map.get(nums2[i]);
                if (stk.isEmpty()) nge[idx] = -1; else nge[idx] = stk.peek();
            }
            stk.push(nums2[i]);
        }
        return nge;
    }
}

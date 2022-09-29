class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            if (i < k) {
                pq.add(new int[] { diff, arr[i] });
            } else {
                if (diff < pq.peek()[0]) {
                    pq.poll();
                    pq.add(new int[] { diff, arr[i] });
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        Collections.sort(res);
        return res;
    }
}

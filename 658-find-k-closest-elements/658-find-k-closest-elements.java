class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Arrays.sort(arr);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.first - a.first);
        for (int i = 0; i < k; i++) pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));
        for (int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            if ((diff == pq.peek().first && arr[i] < pq.peek().second) || diff < pq.peek().first) {
                pq.poll();
                pq.add(new Pair(diff, arr[i]));
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().second);
        }
        Collections.sort(res);
        return res;
    }
}

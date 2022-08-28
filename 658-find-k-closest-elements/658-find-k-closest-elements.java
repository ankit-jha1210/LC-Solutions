class Solution {

    class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.first - a.first);
        int i = 0;
        while (i < k) pq.add(new Pair(Math.abs(arr[i] - x), arr[i++]));
        while (i < arr.length) {
            int diff = Math.abs(arr[i] - x);
            if (pq.peek().first > diff) {
                pq.poll();
                pq.add(new Pair(diff, arr[i]));
            }
            i++;
        }
        List<Integer> lst = new ArrayList<>();
        while (!pq.isEmpty()) lst.add(pq.poll().second);
        Collections.sort(lst);
        return lst;
    }
}

class Pair<T,V>{
    T first;
    V second;
    Pair(T first, V second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = 
            new PriorityQueue<>((a, b) -> b.first - a.first);
        
        for(int[] point: points){
            int dist = point[0]*point[0] + point[1]*point[1];
            pq.add(new Pair<>(dist, new Pair<>(point[0], point[1])));
            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            Pair<Integer, Pair<Integer, Integer>> p = pq.poll();
            res[i][0] = p.second.first;
            res[i++][1] = p.second.second;
        }
        return res;
    }
}
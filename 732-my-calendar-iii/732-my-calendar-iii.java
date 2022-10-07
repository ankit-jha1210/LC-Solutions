class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int sum = 0, ans = 0;
        for (Integer val : map.values()) {
            sum += val;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

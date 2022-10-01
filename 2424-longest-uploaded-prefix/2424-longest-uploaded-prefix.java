class LUPrefix {
    HashSet<Integer> set;
    int max;

    public LUPrefix(int n) {
        set = new HashSet<>();
        max = 0;
    }

    public void upload(int video) {
        set.add(video);
        while (set.contains(max + 1)) max++;
    }

    public int longest() {
        return max;
    }
}

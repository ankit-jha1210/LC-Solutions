class DataStream {
    int k;
    int value;
    int size = 0;

    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
    }

    public boolean consec(int num) {
        if(num != value) {
            size = 0;
            return false;
        }
        size++;
        if(size < k) return false;
        return true;
    }
}
/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */

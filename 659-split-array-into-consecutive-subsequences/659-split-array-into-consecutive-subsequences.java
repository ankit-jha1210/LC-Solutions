class Solution {

    public boolean isPossible(int[] nums) {
        // hashing the no. of jobs a person can take
        HashMap<Integer, Integer> availability = new HashMap<>();
        HashMap<Integer, Integer> want = new HashMap<>();
        for (int num : nums) availability.put(num, availability.getOrDefault(num, 0) + 1);

        for (int num : nums) {
            if (availability.getOrDefault(num, 0) > 0) {
                if (want.getOrDefault(num, 0) > 0) {
                    availability.put(num, availability.getOrDefault(num, 0) - 1);
                    want.put(num + 1, want.getOrDefault(num + 1, 0) + 1);
                    want.put(num, want.getOrDefault(num, 0) - 1);
                } else if (availability.getOrDefault(num + 1, 0) > 0 && availability.getOrDefault(num + 2, 0) > 0) {
                    want.put(num + 3, want.getOrDefault(num + 3, 0) + 1);
                    availability.put(num, availability.getOrDefault(num, 0) - 1);
                    availability.put(num + 1, availability.getOrDefault(num + 1, 0) - 1);
                    availability.put(num + 2, availability.getOrDefault(num + 2, 0) - 1);
                } else return false;
            }
        }
        return true;
    }
}

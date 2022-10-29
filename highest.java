public class highest {

	public static char highestOccuringChar(String str) {
        int freq[] = new int[255];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = (int) str.charAt(i);
            freq[val]++;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxIndex = i;
            }
        }
        char ans = (char) maxIndex;
        return ans;
    }

}

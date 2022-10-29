public class reverseWord {

	public static String reverseEachWord(String str) {
        String strAns = "";
        int startingIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                String revEachWord = "";
                int endingIndex = i - 1;
                for (int j = startingIndex; j <= endingIndex; j++) {
                    revEachWord = str.charAt(j) + revEachWord;
                }
                startingIndex = i + 1;
                strAns += revEachWord + " ";
            }
            
            String revEachWord = "";
            if (i == str.length() - 1) {
                for (int k = startingIndex; k < str.length(); k++) {
                    revEachWord = str.charAt(k) + revEachWord;
                }
                strAns += revEachWord;
            }
        }
        return strAns;
    }

}

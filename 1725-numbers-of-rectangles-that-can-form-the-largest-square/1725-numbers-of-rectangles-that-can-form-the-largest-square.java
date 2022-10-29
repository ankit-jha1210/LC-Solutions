class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int ans = 0;
        int maxLength = 0;
        int tempMax = 0;
        int rectSize = rectangles.length;
        for(int i=0; i<rectSize; i++){
            if(rectangles[i][0]<rectangles[i][1]){
                tempMax = rectangles[i][0];
            }else{
                tempMax = rectangles[i][1];
            }
            if(maxLength<tempMax){
                maxLength = tempMax;
                ans = 1;
            }else if(maxLength==tempMax){
                ans++;
            }
        }
        return ans;
    }
}
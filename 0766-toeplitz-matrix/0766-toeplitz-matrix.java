class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(!map.containsKey(i - j)) map.put(i - j, matrix[i][j]);
                else if(map.get(i - j) != matrix[i][j]) return false;
            }
        }
        return true;
    }
}
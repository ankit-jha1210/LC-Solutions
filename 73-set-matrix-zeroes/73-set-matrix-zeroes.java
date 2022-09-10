class Solution {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public void setZeroes(int[][] matrix) {
        ArrayList<Pair> lst = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    lst.add(new Pair(i,j));
                }
            }
        }
        for(int i=0;i<lst.size();i++){
            int row = lst.get(i).row;
              int col = lst.get(i).col;
            for(int k=0;k<n;k++){
                matrix[k][col] = 0;
            }
            for(int k=0;k<m;k++){
                matrix[row][k] = 0;
            }
        }
    }
}
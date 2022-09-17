class Solution {

    public boolean isRobotBounded(String instructions) {
        char dir = 'N';
        int x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                y += dir == 'N' ? 1 : 0;
                y += dir == 'S' ? -1 : 0;
                x += dir == 'E' ? 1 : 0;
                x += dir == 'W' ? -1 : 0;
            } else {
                if (dir == 'N') {
                    dir = ch == 'L' ? 'W' : 'E';
                }
                else if(dir == 'S') {
                    dir = ch == 'L' ? 'E':'W';
                }
                else if(dir == 'W'){
                    dir = ch == 'L' ? 'S' : 'N';
                }
                else {
                    dir = ch == 'L'?'N':'S';
                }
            }
        }
        if ((x == 0 && y == 0) || dir != 'N') return true;
        return false;
    }
}

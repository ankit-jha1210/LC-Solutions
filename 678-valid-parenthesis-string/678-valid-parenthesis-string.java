class Solution {

    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') open.push(i); 
            else if (ch == '*') star.push(i); 
            else {
                if (!open.isEmpty()) open.pop(); 
                else if (!star.isEmpty()) star.pop(); 
                else return false;
            }
        }
        // balancing the open brackets
        while(!open.isEmpty()){
            int idx = open.pop();
            if(star.isEmpty() || star.peek() < idx) return false;
            star.pop();
        }
        return true;
    }
}

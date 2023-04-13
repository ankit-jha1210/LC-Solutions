//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B ) {
        
        return solve(A, 0, B) ? 1 : 0;
    }
    
    static boolean solve(String s, int ind, ArrayList<String> B) {
        
        if(ind == s.length()) return true;
        
        for(int j = ind; j < s.length(); j++) {
            
            String res = s.substring(ind, j + 1);
            
            if(B.contains(res) && solve(s, j + 1, B))  return true;
            }
            
        return false;
        }
}
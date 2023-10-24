//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap <Character,Integer>map=new HashMap<>();
        int i=0,j=0;
        int ans=-1;
        while(i<s.length()){
            if(j<s.length()&&map.size()<=k){
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                j++;
                if(map.size()==k){
                    ans=Math.max(ans,j-i);
                }
            }
            else if(i<s.length()&&map.size()>k){
                char ch=s.charAt(i);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)map.remove(ch);
                i++;
            }else{
                return ans;
            }
        }
        return ans;
    }
}
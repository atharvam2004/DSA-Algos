//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends
class Solution {

    int search(String pat, String txt) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<pat.length();i++){
            char character = pat.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);        
        }
        int conflicts=map.size();
        int ans=0;
        for(int i=0;i<pat.length();i++){
            char character = txt.charAt(i);
            if(map.containsKey(character)){
                if(map.get(character)==0)conflicts++;
                map.put(character, map.get(character) - 1);
                if(map.get(character)==0)conflicts--;
            }
        }
        if(conflicts==0)ans++;
        int j=pat.length();
        for(int i=0;j<txt.length();i++){
            char character = txt.charAt(j);
            if(map.containsKey(character)){
                if(map.get(character)==0)conflicts++;
                map.put(character, map.get(character) - 1);
                if(map.get(character)==0)conflicts--;
            }
            character = txt.charAt(i);
            if(map.containsKey(character)){
                if(map.get(character)==0)conflicts++;
                map.put(character, map.get(character) + 1);
                if(map.get(character)==0)conflicts--;
            }
            if(conflicts==0)ans++;
            j++;
        }
        return ans;
    }
}
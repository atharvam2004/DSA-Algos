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
   public int longestkSubstr(String str, int k) {
        // code here
        int n=str.length();
		HashMap<Character,Integer>map=new HashMap<>();
		
		int i=0,j=0,max=-1;
		while(j<n) {
			Integer J=map.get(str.charAt(j));
			map.put(str.charAt(j),(J==null)?1:J+1 );
			if(map.size()==k) {
				max=Math.max(max,j-i+1);						
			}
			if(map.size()>k) {
				max=Math.max(max, j-i);
				while(map.size()>k) {
					J=map.get(str.charAt(i));
					if(J-1==0)
						map.remove(str.charAt(i));
					else
						map.put(str.charAt(i), J-1);
					i++;
				}
			}
			j++;

		}
        return max;
    }
}
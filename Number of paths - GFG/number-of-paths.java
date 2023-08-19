//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}




// } Driver Code Ends


class Solution{
    
    long numberOfPaths(int m, int n) {
        // Code Here
        long ans=0;
        return countPaths(ans,0,0,m,n);
    }
     long countPaths(long ans,int row, int column,int m,int n) {
         if(row==m-1||column==n-1){
             ans++;
             return ans;
         }
         ans=countPaths( ans, row+1, column,m,n);
         ans=countPaths( ans, row,  column+1,m,n);
         return ans;
    }
    
    
}
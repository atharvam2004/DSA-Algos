//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<n+1;i++){
            dp[1][i]=i*price[0];
        }
        for(int i=2;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                int take=0;
                if(j-i>=0)
                take=price[i-1]+dp[i][j-i];
                int nottake=dp[i-1][j];
                dp[i][j]=Math.max(take,nottake);
            }
        }
       return dp[n][n];
    }
   
}
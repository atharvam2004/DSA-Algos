//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][]=new int[N][W+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            } 
        }
        return helper(N-1,W,val,wt,dp);
    }
    static int helper(int N, int W, int val[], int wt[],int [][] dp)
    {
        if(dp[N][W]!=-1)return dp[N][W];
        if(W==0)return 0;
        if(N==0){
            return (W/wt[0])*val[0];
        }
        int take=0;
        if(W-wt[N]>=0)
        take=val[N]+helper(N,W-wt[N],val,wt,dp);
        int nottake=helper(N-1,W,val,wt,dp);
        return dp[N][W]=Math.max(take,nottake);
    }
}
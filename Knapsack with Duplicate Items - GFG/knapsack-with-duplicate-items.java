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
            dp[i][0]=0;
        }
        for(int i=0;i<W+1;i++){
            dp[0][i]=(i/wt[0])*val[0];
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<W+1;j++){
                int take=0;
                if(j-wt[i]>=0)
                take=val[i]+dp[i][j-wt[i]];
                int nottake=dp[i-1][j];
                dp[i][j]=Math.max(take,nottake);
            }
        }
        return dp[N-1][W];
    }
}
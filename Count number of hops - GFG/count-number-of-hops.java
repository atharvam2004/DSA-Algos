//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // add your code here
        long[] arr=new long[n+1];
        if(n==1||n==0)return 1;
        if(n==2)return 2;
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<n+1;i++){
            int j=i-3;
            while(j<i){
                arr[i]=(arr[i]+arr[j])%1000000007;
                j++;
            }
        }
        return arr[n]%1000000007;
    }
    
}


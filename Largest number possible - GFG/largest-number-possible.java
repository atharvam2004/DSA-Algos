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
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        if(N==1&&S==0){return "0";}
        if(S==0)return "-1";
        if(N==0)return "-1";
        int sum=0;
        int w=S;
        StringBuilder str=new StringBuilder();
        while(N>0){
            if(S>=9){
                S-=9;
                N--;
                str.append('9');
                sum+=9;
            }else{
                sum+=S;
                str.append(S);
                S=0;
                N--;
            }
        }
        while(N>0){
             str.append('0');
        }
        if(sum==0)return "-1";
        if(sum!=w)return "-1";
        return str.toString();
    }
}
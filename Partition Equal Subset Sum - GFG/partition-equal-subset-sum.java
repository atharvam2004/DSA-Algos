//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int req=0;
        for(int i=0;i<arr.length;i++){
            req+=arr[i];
        }
        if(req%2!=0)return 0;
        req/=2;
        Set<Integer>set=new <Integer>HashSet();
        set.add(0);
         for (int i = 0; i < arr.length; i++) {
        Set<Integer> newSet = new HashSet<>(set); // Create a new set to avoid concurrent modification
        for (Integer element : newSet) {
            set.add(element + arr[i]);
        }
        if (set.contains(req)) {
            return 1; // Found a subset that sums to req
        }
    }
        return 0;
    }
    
}
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
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int a[]){
        // code here
        ArrayList <Integer>ans=new ArrayList<>();
        N--;
        int minid=0;
        int secmin=Integer.MAX_VALUE;
        while(a[N-1]>=a[N]){
            N--;
            if(a[N]>a[a.length-1]){
                secmin=Math.min(secmin,a[N]);
            }
            if(N==0){
                for(int i=a.length-1;i>=0;i--){
                    ans.add(a[i]);
                }
                return ans;
            }
        }
        int temp=a[N-1];
        int in=N-1;
        for(int i=a.length-1;i>=N-1;i--){
            if(a[i]>a[in]){
                in=i;
                break;
            }
        }
        a[N-1]=a[in];
        a[in]=temp;
        int[] arr=Arrays.copyOfRange(a,N,a.length);
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            ans.add(a[i]);
        }
        for(int i=0;i<arr.length;i++){
            ans.add(arr[i]);
        }
        return ans;
        
        
    }
}
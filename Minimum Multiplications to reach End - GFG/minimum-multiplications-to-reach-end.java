//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int node,dis;
    pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end)return 0;
        int[] visited=new int[100000];
        PriorityQueue<pair> q=new PriorityQueue<>((x,y)->x.dis-y.dis);
        q.offer(new pair(start,0));
        visited[start]=0;
        while(!q.isEmpty()){
            pair temp=q.poll();
            for(int i=0;i<arr.length;i++){
                int val=temp.node*arr[i]%100000;
                if(visited[val]==0){
                    q.offer(new pair((int)val,temp.dis+1));
                    visited[val]=temp.dis+1;
                }
            }
        }
        if(visited[end]==0)return -1;
        return visited[end];
    }
}

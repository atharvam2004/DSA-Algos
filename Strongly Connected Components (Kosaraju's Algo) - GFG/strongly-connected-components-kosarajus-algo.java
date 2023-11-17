//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private void dfs(int node, int []vis, ArrayList<ArrayList<Integer>> adj,
    Stack<Integer> st) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }    
    private void normaldfs(int node, int []vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 0;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 1) {
                normaldfs(it, vis, adj);
            }
        }
    }    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }
        ArrayList<ArrayList<Integer>> adj2=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj2.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            for(int j:adj.get(i)){
                adj2.get(j).add(i);
            }
        }
        int ans=0;
        for (int i = 0; i < V; i++) {
            int temp=st.pop();
            if(vis[temp]==1){
                ans++;
                normaldfs(temp,vis,adj2);
            }
        }
        return ans;
    }
}

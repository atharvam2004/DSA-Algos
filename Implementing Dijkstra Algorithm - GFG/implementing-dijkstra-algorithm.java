//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class pair{
    int node,dis;
    pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}

class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] ans=new int[V];
        for(int i=0;i<ans.length;i++)
        ans[i]=Integer.MAX_VALUE;
        ans[S]=0;
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)->x.dis-y.dis);
        pq.offer(new pair(S,0));
        while(!pq.isEmpty()){
            pair temp=pq.poll();
            ArrayList<ArrayList<Integer>> arr=adj.get(temp.node);
            int s=arr.size();
            for(int i=0;i<s;i++){
                int curr=arr.get(i).get(0);
                if(ans[curr]>temp.dis+arr.get(i).get(1)){
                    pq.offer(new pair(curr,temp.dis+arr.get(i).get(1)));
                    ans[curr]=temp.dis+arr.get(i).get(1); 
                }
            }
        }
        return ans;
    }
}


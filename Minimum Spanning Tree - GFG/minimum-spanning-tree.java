//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
// class triple{
//     int node1,node2,dis;
//     triple(int node1,int node2,int dis){
//         this.node1=node1;
//         this.node2=node2;
//         this.dis=dis;
//     }
// }
// class pair{
//     int node1,dis;
//     pair(int node1,int dis){
//         this.node=node;
//         this.dis=dis;
//     }
// }
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
    Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
    int[] parent=new int[V];
    for(int i=0;i<V;i++){
        parent[i]=i;
    }
    int ans=0;
//     for(int i=0;i<edges.length;i++){
// 	  	   for(int j=0;j<edges[i].length;j++){
// 	            System.out.print(edges[i][j]);
// 	  	   }
// 	       System.out.println(" ");
// 	 }
    for(int i=0;i<edges.length;i++){
        if(checkpar(edges[i][0],parent)!=checkpar(edges[i][1],parent)){
            ans+=edges[i][2];
            // for(int m=0;m<V;m++){
            //     System.out.print(parent[m]);
            // }
            // System.out.println(" ");
            makepar(edges[i][0],edges[i][1],parent);
        }
    }
   
	return ans;
	}
    static void makepar(int c1, int c2, int parent[]){
        c1=checkpar(c1,parent);
        c2=checkpar(c2,parent);
        parent[c1]=parent[c2];
    }
    static int checkpar(int c1, int parent[]){
        int temp=c1;
        while(parent[temp]!=temp){
            temp=parent[temp];
        }
        parent[c1]=temp;
        return temp;
    }

}
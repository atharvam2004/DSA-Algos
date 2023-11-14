//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(-1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}
class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet d=new DisjointSet(rows*cols);
        int curr=0;
        List<Integer>ans=new ArrayList<>();
        int check1[]={0,1,0,-1};
        int check2[]={1,0,-1,0};
        for(int i=0;i<operators.length;i++){
            int cr=operators[i][0];
            int cc=operators[i][1];
            if(d.parent.get(cr*cols+cc)==-1){
                d.parent.set(cr*cols+cc,cr*cols+cc);
                curr++;
            }
            else{
                ans.add(curr);
                continue;
            }
            for(int j=0;j<4;j++){
                int cr2=cr+check1[j];
                int cc2=cc+check2[j];
                if(cr2>=0&&cc2>=0&&cr2<rows&&cc2<cols){
                    int coord=cr2*cols+cc2;
                    if(d.parent.get(coord)!=-1){
                        if(d.findUPar(coord)!=d.findUPar(cr*cols+cc)){
                        curr--;
                        d.unionByRank(coord,cr*cols+cc);
                        }
                    }
                }
            }
            ans.add(curr);
        }
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
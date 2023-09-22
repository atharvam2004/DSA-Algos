//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m[0][0]==0)return new ArrayList<>();
       return helper(m,0,0,"");
    }
    public static ArrayList<String>  helper(int[][] m, int r,int c, String str) {
     //  System.out.println(str);
         ArrayList<String> ans=new ArrayList<>();
        if(r==m.length-1&&c==m.length-1){
            ans.add(str);
            return ans;
        }
        m[r][c]=0;
        if(r>0&&m[r-1][c]==1)
        ans.addAll(helper(m,r-1,c,str+"U"));
        if(c>0&&m[r][c-1]==1)
        ans.addAll(helper(m,r,c-1,str+"L")); 
        if(r<m.length-1&&m[r+1][c]==1)
        ans.addAll(helper(m,r+1,c,str+"D")); 
        if(c<m.length-1&&m[r][c+1]==1)
        ans.addAll(helper(m,r,c+1,str+"R"));
        m[r][c]=1;
        return ans;
    }
}
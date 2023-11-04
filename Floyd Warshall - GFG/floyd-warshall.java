//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] m)
    {
        int n=m.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(m[j][i]==-1||m[i][k]==-1)continue;
                    int curr=m[j][i]+m[i][k];
                    if(m[j][k]==-1||m[j][k]>curr)m[j][k]=curr;
                }
                for(int k=0;k<n;k++){
                    if(m[k][i]==-1||m[i][j]==-1)continue;
                    int curr=m[k][i]+m[i][j];
                    if(m[k][j]==-1||m[k][j]>curr)m[k][j]=curr;
                }
            }
        }
    }
}
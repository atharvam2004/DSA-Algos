//{ Driver Code Starts
//Initial Template for Java

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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int FindWays(int n, int m, int[][] block){
        int[][] blo=new int[n][m];
        for(int i=0;i<block.length;i++){
           blo[block[i][0]-1][block[i][1]-1]=-1;
        }

        int r=1,c=1;
        if(blo[n-1][m-1]==-1){return 0;}
        for(int i=0;i<n;i++){
            if(blo[i][0]==-1){
                break;
            }
            blo[i][0]=1;
        }

        for(int i=0;i<m;i++){
            if(blo[0][i]==-1){
                break;
            }
            blo[0][i]=1;
        }
        
        while(r<n&&c<m){
        // for(int i=r;i<n;i++){
        //     if(blo[i][c]==-1){
        //         continue;
        //     }
        //     else if(blo[i-1][c]==-1&&blo[i][c-1]==-1){
        //         continue;
        //     }
        //     else if(blo[i-1][c]==-1){
        //         blo[i][c]=blo[r][c-1];
        //     }else if(blo[i][c-1]==-1){
        //         blo[i][c]=blo[i-1][c];
        //     }else{
        //         blo[i][c]=blo[i-1][c]+blo[i][c-1];
        //         if(blo[i][c]<0){
        //             blo[i][c]=0;
        //         }
        //     }
        // }
        for(int i=c;i<m;i++){
             if(blo[r][i]==-1){
                continue;
            }else if(blo[r-1][i]==-1&&blo[r][i-1]==-1){
                continue;
            }
            else if(blo[r-1][i]==-1){
                blo[r][i]=blo[r][i-1];
            }else if(blo[r][i-1]==-1){
                blo[r][i]=blo[r-1][i];
            }else{
                blo[r][i]=blo[r-1][i]+blo[r][i-1];
                if(blo[r][i]<0){
                    blo[r][i]=0;
                }
            }
        }
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(blo[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
         r++;
        }
        return blo[n-1][m-1]%1000000007;
    }
}
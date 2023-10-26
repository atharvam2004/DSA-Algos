//{ Driver Code Starts
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
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class pair{
    int i,j,dis;
    pair(int i,int j,int dis){
        this.i=i;
        this.j=j;
        this.dis=dis;
    }
}
class Solution
{
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int r=grid.length;
        int c=grid[0].length;
        boolean visited[][]=new boolean[r][c];
        int ans[][]=new int[r][c];
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                q.offer(new pair(i,j,0));
            }
        }
        while(!q.isEmpty()){
            pair temp=q.poll();
            if(temp.i<0||temp.j<0||temp.i>=r||temp.j>=c||ans[temp.i][temp.j]!=0)
            continue;
            if(grid[temp.i][temp.j]==1&&temp.dis!=0)
            continue;
            ans[temp.i][temp.j]=temp.dis;
            q.offer(new pair(temp.i+1,temp.j,temp.dis+1));
            q.offer(new pair(temp.i,temp.j+1,temp.dis+1));
            q.offer(new pair(temp.i-1,temp.j,temp.dis+1));
            q.offer(new pair(temp.i,temp.j-1,temp.dis+1));
        }
        return ans;
    }
}
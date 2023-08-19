//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] grid = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findAllPossiblePaths(a[0],a[1], grid);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int m,int n, int[][] grid) {
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(grid[0][0]);
        return  countPaths(0,0,m,n,grid,ans);
    }
    public static ArrayList<ArrayList <Integer>> countPaths(int row, int column,int m,int n, int[][] grid, ArrayList<Integer> ans) {
         if(row==m-1||column==n-1){
            ArrayList<ArrayList <Integer>>total=new ArrayList<>();
             if(row==m-1){
                 while(column!=n-1){
                     column++;
                     ans.add(grid[row][column]);
                 }
             }
              if(column==n-1){
                 while(row!=m-1){
                     row++;
                     ans.add(grid[row][column]);
                 }
             }
        //     System.out.println(ans.toString());
             total.add(ans);
             return total;
         }

        ArrayList<ArrayList <Integer>>total=new ArrayList<>();
          ArrayList<Integer> ans2=new ArrayList<>();
          ans2.addAll(ans);
          ans2.add(grid[row+1][column]);
         total.addAll(countPaths(row+1, column,m,n,grid,ans2));
          ArrayList<Integer> ans3=new ArrayList<>();
          ans3.addAll(ans);
          ans3.add(grid[row][column+1]);
         total.addAll(countPaths(row, column+1,m,n,grid,ans3));
         return total;
    }
}
        

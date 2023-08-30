//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
  ArrayList<Integer> al=new ArrayList<Integer>();
        int[] w={0,matrix[0].length};
        int[] h={0,matrix.length};
        int i=0,j=0;
        int pass=1;
        int total=matrix[0].length*matrix.length;
        while(h[0]<h[1]&&w[0]<w[1]){
           if(pass==1){
              while(j<w[1]){
                  al.add(matrix[i][j]);
                   j++;
              }
              j--;i++;pass=2;h[0]++;
           }
           else if(pass==2){
              while(i<h[1]){
                  al.add(matrix[i][j]);
                   i++;
              }
              i--;j--;pass=3;w[1]--;
           }
          else if(pass==3){
              while(j>=w[0]){
                  al.add(matrix[i][j]);
                   j--;
              }
              j++;i--;pass=4;h[1]--;
           }
           else if(pass==4){
              while(i>=h[0]){
                  al.add(matrix[i][j]);
                   i--;
              }
              i++;j++;pass=1;w[0]++;
           }
        }
        return al;   
        }
}

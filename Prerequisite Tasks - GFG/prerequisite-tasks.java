//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] pre)
    {
        List<List<Integer>>al=new ArrayList<>();
        for(int i=0;i<N;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<P;i++){
            al.get(pre[i][1]).add(pre[i][0]);
        }
        int[] inorder=new int[N];
        for(int i=0;i<P;i++){
            inorder[pre[i][0]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(inorder[i]==0)q.offer(i);
        }
        int total=0;
        while(!q.isEmpty()){
            int temp=q.poll();
            total++;
            for(int i:al.get(temp)){
                inorder[i]--;
                if(inorder[i]==0){
                  q.offer(i);
                }
            }
        }
        
        if(total!=N)return false;
        return true;
    }
    
}
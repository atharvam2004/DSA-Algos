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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
         helper(nums,ans,0,nums.length-1);
        int[] intArray = ans.stream().mapToInt(Integer::intValue).toArray();

         return intArray;
    }
    public ArrayList<Integer> helper(int[] nums,ArrayList<Integer>ans,int low,int high)
    {
        int mid=(high+low)/2;
         if(low>high){
         //   ans.add(nums[mid]);
            return ans;
        }
        ans.add(nums[mid]);
        helper(nums,ans,low,mid-1);
        helper(nums,ans,mid+1,high);
        return ans;
    }
}
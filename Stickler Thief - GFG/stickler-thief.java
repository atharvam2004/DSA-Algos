//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int nums[], int n)
    {
        int prev1=0;
		int prev2=0;
		prev2=nums[0];
		if(nums.length==1)return nums[0];
		prev1=Math.max(nums[0],nums[1]);
		if(nums.length==2)return Math.max(nums[0],nums[1]);
		for(int i=2;i<nums.length;i++){
			int temp=Math.max(nums[i]+prev2,prev1);
			prev2=prev1;
			prev1=temp;
		}
		return prev1 ; 
    }
}
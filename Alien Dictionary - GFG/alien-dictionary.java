//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        for(int i=0;i<K;i++){
            arr.add(new ArrayList<>());
        }
        int ind=0;
        for(int i=0;i<N-1;i++){
            String str1=dict[i];
            String str2=dict[i+1];
            int j=0;
            while(j<str1.length()&&j<str2.length()&&str1.charAt(j)==str2.charAt(j))j++;
            if(j!=str1.length()&&j!=str2.length()){
                arr.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
            }
        }
        StringBuilder str=new StringBuilder();
        Queue <Integer>q=new LinkedList<>();
        int[] indegree=new int[K];
        for(int i=0;i<K;i++){
            for(int g : arr.get(i)){
                indegree[g]++;
            }
        }
        for(int i=0;i<K;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();
            str.append((char)(temp + 'a'));
            for(int ver:arr.get(temp)){
                indegree[ver]--;
                if(indegree[ver]==0)q.add(ver);
            }
        }
        return str.toString();
    }
}
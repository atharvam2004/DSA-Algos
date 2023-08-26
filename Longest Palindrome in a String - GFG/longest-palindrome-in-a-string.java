//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        String ans="";
                    String cand1="";
                    String cand2="";
        for(int i=0;i<S.length();i++){
            if(i<S.length()-1)
             cand1=checkPalin(i,i+1,S);
             cand2=checkPalin(i,i,S); 
            if(cand1.length()>ans.length()){
                ans=cand1;
            }
            if(cand2.length()>ans.length()){
                ans=cand2;
            }
        }
        return ans;
        
    }
    static String checkPalin(int i,int j,String S){
       
        while(i>=0&&j<S.length()){
            if(S.charAt(i)==S.charAt(j)){
                i--;j++;
            }else{break;}
        }
        return S.substring(i+1,j);
        
    }
}
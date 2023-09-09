//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(String[] arr) {
         descsort(arr);
        String sortedString = String.join("", arr); 
        return sortedString;
    }
    void descsort(String[] arr){
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        String[] left = Arrays.copyOfRange(arr, 0, mid);
        String[] right = Arrays.copyOfRange(arr, mid, n);
        descsort(left);
        descsort(right);
        arrange( arr,left, right);
    }
    void arrange(String[] arr,String[] str1,String[] str2){
        int i=0,j=0,k=0;
            while(i<str1.length&&j<str2.length){
            String num1 = str1[i] + str2[j];
            String num2 = str2[j] + str1[i];
            int comparisonResult = num2.compareTo(num1);
            if (comparisonResult > 0) {
                arr[k] = str2[j];
                j++;
            } else {
                arr[k] = str1[i];
                i++;
            }
            k++;
        }
        while (i < str1.length) {
            arr[k] = str1[i++];
            k++;
        }

        while (j < str2.length) {
            arr[k] = str2[j++];
            k++;
        }
      
    }
}
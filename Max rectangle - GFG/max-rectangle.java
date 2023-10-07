//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        int ans=0;
        ArrayList <Integer>al=new ArrayList<>();
        for(int i=0;i<M[0].length;i++){
            al.add(0);
        }
        for(int i=0;i<M.length;i++){
            al=getAl(M,al,i);
            Stack<Integer>st=new Stack<>();
            int[] preSmall =new int[M[0].length];
            int[] nextSmall=new int[M[0].length];
            for(int j=0;j<al.size();j++){
                while(!st.isEmpty() && al.get(st.peek())>=al.get(j))st.pop();
                if(st.isEmpty())preSmall[j]=-1;
                else preSmall[j]=st.peek();
                st.push(j);
            }
            st.clear();
            for(int j=al.size()-1;j>=0;j--){
                while(!st.isEmpty() && al.get(st.peek())>=al.get(j))st.pop();
                if(st.isEmpty())nextSmall[j]=M[0].length;
                else nextSmall[j]=st.peek();
                st.push(j);
            }
            for(int j=0;j<al.size();j++){
                ans=Math.max(ans,al.get(j)*(nextSmall[j]-preSmall[j]-1));
            }
        }
        
        return ans;
    }
    public ArrayList<Integer> getAl(int M[][], ArrayList <Integer>al, int i) {
        ArrayList<Integer>op=new ArrayList<>();
        for(int j=0;j<M[0].length;j++){
            if(M[i][j]==0){
                op.add(0);
            }
            else{
                op.add(M[i][j]+al.get(j));
            }
        }
        return op;
    }
}
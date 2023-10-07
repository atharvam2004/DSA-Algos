//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
            //add code here.
        return s.pop();
	}
	public int min(Stack<Integer> s)
    {
        int ans=Integer.MAX_VALUE;
        Stack <Integer>s2=new Stack();
        while(!s.isEmpty()){
            s2.push(s.pop());
            ans=Math.min(ans,s2.peek());
        }
        while(!s2.isEmpty()){
            s.push(s2.pop());
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        if(s.size()>=n)return true;
        return false;
	}
	public boolean isEmpty(Stack<Integer>s)
    {
        if(s.isEmpty())return true;
        return false;
	}
}
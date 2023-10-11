//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class tuple{
    int level;
    Node n;
    tuple(int level, Node n){
        this.level=level;
        this.n=n;
    }
}
class Solution
{
   
    static ArrayList<Integer> topView(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        helper(root,map,0);
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
    }
    static void helper(Node root,Map<Integer,Integer> map,int ver)
    {
        Queue <tuple>q=new LinkedList<>();
        q.offer(new tuple(0,root));
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                tuple temp=q.poll();
                int curr=temp.level;
                if(!map.containsKey(temp.level)){
                    map.put(temp.level,temp.n.data);
                }
                if(temp.n.left!=null)q.offer(new tuple(curr-1,temp.n.left));
                if(temp.n.right!=null)q.offer(new tuple(curr+1,temp.n.right));
            }
        }
    }
    
}
package com.ds.graphnode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
--------------------------------------------------------------------
Example ordering of Depth First Walk:

                   1
                   |
           2 - 9 - 10 - 11 - 12 
           |                  | 
         3 - 6           13 ----- 15
         |   |           |         |
     4 - 5   7 - 8       14   16 - 17 - 18 

--------------------------------------------------------------------

Please provide a:
Depth First Walk Function - recursive
Depth First Walk Function - non-recursive
Breadth First Walk Function 

 */
public class BFSDFSNAryNodes {

	class Node extends LinkedList<Node> {
		List<Node> list = new LinkedList<Node>();
		private String data = "";

		public Node(String value) {
			this.data = value;
		}

		public List<Node> getList() {
			return list;
		}
	}


	public void dfs(Node node) {
	    
	    
		System.out.println(node.data);
		int childcount = node.getList().size();
	    
		if (childcount == 0) {
	        // leaf
	        
	    } else {
	        for(int i = 0; i < childcount; i++) {
				Node tmp = node.getList().get(i);
	            dfs(tmp);
	        }
	    }
	}

	public void bfs(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.data);

			for (Node element : n.getList()) {
				q.offer(element);
			}
		}
	}

	public void dfsIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);

		while (!stack.empty()) {
			Node n = stack.pop();
			System.out.println(n.data);
			for (Node element : n.getList()) {
				stack.push(element);
			}
		}
	}

	public static void main(String[] args) {

	}

}

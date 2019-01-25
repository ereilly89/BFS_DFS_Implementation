
package compsci_332_project1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	public Node findNode(String name, ArrayList<Node> v) {//returns a Node if the name matches one within the array list
		for (int i = 0; i < v.size(); i++) {
			Node aNode = v.get(i);
			if (aNode.getName().equalsIgnoreCase(name))
				return aNode;
		}
		return null;
	}

	public String DFS(String s0, ArrayList<Node> v, String goal) throws Exception {
		String path = "";
		Stack stack = new Stack();
		Node s0Node = findNode(s0, v);
		s0Node.setVisited(true);
		stack.push(s0Node);

		while (!stack.isEmpty()) {
			Node tNode = (Node) stack.pop();
			if (tNode.getName().equalsIgnoreCase(goal)) {
				path += goal;
				return path;
			}
			path += tNode.getName()+" ";

			ArrayList<String> neighborList = tNode.getNeighbors();
			String u;

			if (neighborList == null)
				continue;

			for (int i = 0; i < neighborList.size(); i++) {
				try {
					Node uNode = findNode(neighborList.get(i), v);
					if (!uNode.isVisited()) {
						uNode.setVisited(true);
						stack.push(uNode);
					} // end of if
				}catch(NullPointerException e) {
					ArrayList<String> emptyArrayList = new ArrayList();
					Node zNode = new Node(neighborList.get(i),true,emptyArrayList);
					stack.push(zNode);
				} 	
			} // end of loop
		} // end of while
		return path;
	}// end of DFS
}

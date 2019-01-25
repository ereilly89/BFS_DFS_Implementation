
package compsci_332_project1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public Node findNode(String name, ArrayList<Node> v) {//returns a Node if the name matches one within the array list
		for (int i = 0; i < v.size(); i++) {
			Node aNode = v.get(i);
			if (aNode.getName().equalsIgnoreCase(name))
				return aNode;
		}
		return null;
	}

	public String BFS(String s0, ArrayList<Node> v, String goal) throws Exception {//Breadth First Search implementation
		String path = "";
		Queue queue = new LinkedList();
		Node s0Node = findNode(s0, v);
		s0Node.setVisited(true);
		queue.add(s0Node);

		while (!queue.isEmpty()) {
			Node tNode = (Node) queue.remove();
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
							queue.add(uNode);
						} // end of if
					}catch(NullPointerException e) {//Creates a node if uNode is null
						ArrayList<String> emptyArrayList = new ArrayList();
						Node zNode = new Node(neighborList.get(i),true,emptyArrayList);
						queue.add(zNode);
					}
			} // end of loop
		} // end of while
		return path;
	}// end of BFS
}

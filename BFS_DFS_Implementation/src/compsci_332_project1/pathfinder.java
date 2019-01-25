package compsci_332_project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class pathfinder {
	public static void main(String[] args) throws Exception {
		
		//Declare Variables
		boolean noFile = true, noStartingPoint = true, noGoal = true;
		String myFile = "map.txt";
		Scanner input = new Scanner(System.in);
		Scanner map = new Scanner(new File(myFile));
		BFS obj = new BFS();
		DFS obj1 = new DFS();
		
		//Ask user for file name
		System.out.print("Enter file name ('map.txt'): ");
		String theFile = input.next();
		
		while (noFile) {
			if (theFile.equals(myFile)) {
				System.out.println("Success... Using 'map.txt'");
				noFile = false;
			} else {
				System.out.println("Failure... Could not find '" + theFile + "'");
				System.out.println("Enter file name ('map.txt'): ");
				theFile = input.next();
			}
		}
		
		// Ask user for a starting point
		System.out.print("Starting point ('annex' or other location from the 'map.txt' file): ");
		String s0 = input.next();
		
		//Ask user for the goal
		System.out.print("Goal ('main' or other location from the 'map.txt' file: ");
		String goal = input.next();
		System.out.println();
		
		// Convert txt file to node mapping
		ArrayList<Node> v = new ArrayList();
		int size=0;
		while(map.hasNext()) {
			String currentNode = map.next();
			try {
				obj.findNode(currentNode,v).getNeighbors().add(map.next()); 
			}catch(NullPointerException e) {
				v.add(new Node(currentNode));
				ArrayList<String> temperary = new ArrayList();
				String list = map.next();
				temperary.add(list);
				obj.findNode(currentNode, v).setNeighbors(temperary);
			}
		}
		
		//Display the results of the Breadth First Search Algorithm
		System.out.println("~~~~~BFS~~~~~~");
		
		//Reset the nodes
		System.out.println(obj.BFS(s0,v,goal));
		for(int i=0;i<v.size();i++) {
			v.get(i).setVisited(false);
		}
		//Display the results of the Depth First Search Algorithm
		System.out.println("~~~~~DFS~~~~~~");
		System.out.println(obj1.DFS(s0,v,goal));
	}
}

import java.util.ArrayList;

//Author: David Besonen
//Date: 10/26/19

/* Performs a Breadth-First Search of a tree represented as a two-dimensional 
adjacency matrix and then outputs the tree children-first */

public class breadthFirst {

	// Generates an ArrayList consisting of all connections between vertices
	// in a tree (represented as an adjacency matrix)
	public static ArrayList<String> connectionGenerator(int[][] a) {
		ArrayList<String> answer = new ArrayList<String>();
		boolean added = false;

		for (int r = 0; r < a.length; r++) {
			for (int c = r + 1; c < a.length; c++) {
				if (a[r][c] > 0) {
					answer.add(r + "," + c);
					added = true;
				}

				// If the source vertex is not connected to anything
				if (c == a.length - 1 && added == false) {
					answer.add(r + ",null");
				}
			}
		}
		return answer;
	}

	// Performs a breath-first search of a tree (represented as 
	// an ArrayList of vertex connections) for a given value
	public static String breadthFirstSearch(ArrayList<String> list, int value) {
		int parent, child;
		String[] tok;

		// Increments through list of tree connections
		for (int i = 0; i < list.size(); i++) {
			tok = list.get(i).split(",");
			parent = Integer.parseInt(tok[0]);
			child = Integer.parseInt(tok[1]);

			// Checks for value at the root of the tree
			if (i == 0) {
				if (parent == value) {
					System.out.println("Searching Root: " + parent);
					return "Value " + value + " has been found at location: Root";
				}
			}

			// Prints breadth-first search path
			System.out.println("Parent: " + parent + " searching Child: " + child);

			// Checks for value in the children of the parent node
			if (child == value) {
				return "Value '" + value + "' has been found at location Parent: " + parent;
			}
		}

		return "Value '" + value + "' not found in tree";
	}

	// Prints children-frist, all values of a tree represented by an adjacency matrix
	public static void levelPrint(ArrayList<String> list) {
		String parent, child;
		String[] tok;

		// Increments through a list of connections between vertices from end to beginning
		for (int i = list.size() - 1; i >= 0; i--) {
			tok = list.get(i).split(",");
			parent = tok[0];
			child = tok[1];

			// Prints root of tree
			if (i == 0) {
				System.out.println("Root: " + parent);
			}

			// Prints children of tree
			else {
				System.out.println("Child: " + child + ", Parent: " + parent);
			}
		}
	}

	public static void main(String[] args) {
		int[][] treeOne = { { 0, 1, 1, 0, 0, 0, 0 }, { 1, 0, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 1, 1 },
				{ 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0 } };

		int[][] treeTwo = { { 0, 1, 1, 0, 0, 0, 0 }, { 1, 0, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 1, 0 } };

		System.out.println("Breadth-First Search");
		// Outputs the result of a breadth-first search on given adjacency matrix
		System.out.println(breadthFirstSearch(connectionGenerator(treeOne), 6));

		System.out.println("\nLevel Print");
		// Outputs the children first of a tree represented by an adjacency matrix
		levelPrint(connectionGenerator(treeTwo));
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * DecisionTree class used to create a tree of
 * GuessNode and QuestionNode
 * @author Dennis Chan
 * @author Linh Pham
 */
public class DecisionTree implements DecisionNode {
	public Scanner scan = new Scanner(System.in);
	private DecisionNode root;

	/**
	 * Construct a DecisionTree with the first guess 
	 */
	public DecisionTree () {
		this.root = new GuessNode ("Boeing 757");
	}

	/**
	 * Construct a DecisionTree stored in a serialized form in the given file
	 * @param file 
	 * 
	 */
	public DecisionTree(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		this.root = addNode(file, in);
	}
	/**
	 * Count the number of GuessNodes in the tree
	 */
	public int countObjects() {
		return root.countObjects();
	}
	
	/**
	 * Writes the tree to the file
	 */

	public void write(FileWriter out) throws IOException {
		root.write(out);
	}

	/**
	 * Perform the guessing game on the tree
	 */
	public DecisionNode guess(Scanner in) {
		return root.guess(in);
	}
	
	/**
	 * De-serialize a DecisionTree from a file
	 * @param file
	 * @param scan, a Scanner to go through every line of the file
	 */

	public DecisionNode addNode (File file, Scanner scan) throws FileNotFoundException {
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if ((line.substring(0,  1)).equals("#")) {
				return new QuestionNode(line.substring(1, line.length()), addNode(file, scan), addNode(file, scan));
			} else {
				return new GuessNode(line);
			}
		}
		return root;
	}
}

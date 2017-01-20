import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * QuestionNode class used to create Node that contains the
 * question and the answers in the left and right branches
 * @author Dennis Chan
 * @author Linh Pham
 */
public class QuestionNode implements DecisionNode{

	public String question;
	public DecisionNode left;
	public DecisionNode right;
	
	/**
	 * Constructor for QuestionNode class
	 * @param string contains the question
	 */
	public QuestionNode (String question) {
		this(question, null, null);
	}
	
	/**
	 * Constructor for QuestionNode class
	 * @param string contains the question
	 * @param left, a left branch DecisioNode
	 * @param right, a right branch DecisionNode
	 */
	public QuestionNode (String question, DecisionNode left, DecisionNode right) {
		this.question = question;
		this.left = left;
		this.right = right;
	}

	/**
	 * Count the number of GuessNode in the QuestionNode
	 */
	public int countObjects() {
		return this.left.countObjects() + this.right.countObjects();
	}

	/**
	 * Performs the guessing on the right branch of 
	 * the DecisionTree
	 * @param in, a Scanner	
	 */
	public DecisionNode guess(Scanner in) {
		System.out.print(question + " ");
		String input = in.nextLine();
		
		if (input.equalsIgnoreCase("Yes")) {
			this.left = this.left.guess(in);
		} else if (input.equalsIgnoreCase("No")) {
			this.right = this.right.guess(in);
		} else {
			System.out.println("\nInvalid Response. Enter yes or no next time!");
		}
		
		return this;
	}
	/**
	 * Writes the current question to a file
	 */

	public void write(FileWriter out) throws IOException {
		out.write("#" + question + "\n");
		left.write(out);
		right.write(out);
	}
}
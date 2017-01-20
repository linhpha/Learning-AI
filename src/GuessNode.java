import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Implementing GuessNode class that contains all guess that
 * the program makes
 * @author Dennis Chan
 * @author Linh Pham
 */

public class GuessNode implements DecisionNode{

	private String guess;
	/**
	 * Constructor for GuessNode class
	 * @param string contains the guess
	 */
	public GuessNode(String string) {
		this.guess = string;
	}
	
	/**
	 * Performs the guessing on the Guess branch of 
	 * the DecisionTree
	 * @param in, a Scanner	
	 */
	public DecisionNode guess(Scanner in) {
		System.out.print("Are you thinking of a " + guess + "? ");
		String input = in.next();

		if (input.equalsIgnoreCase("Yes")) {
			System.out.println("Excellent!");
			return this;
			
		} else if (input.equalsIgnoreCase("No")) {
			System.out.print("\nWhat object were you thinking about? ");
			in.nextLine();
			String g = in.nextLine();
			System.out.println("What is a yes/no question that distinguishes between a " + guess + 
					" and a " + g + "? ");
			System.out.print("(Yes corresponds to " + guess + "; No corresponds to " + g + "). ");
			String q = in.nextLine();
			System.out.println("Thanks! I'll learn from this experience!");
			return new QuestionNode(q, new GuessNode(guess) , new GuessNode(g));
			
		} else {
			System.out.println("\nInvalid Response. Enter yes or no next time!");
			return null;
		}
	}

	/**
	 * Count the number of GuessNode
	 */
	public int countObjects() {
		return 1;
	}
	
	/**
	 * Writes the current guess node to a file
	 */
	public void write(FileWriter out) throws IOException {
		out.write(guess + "\n");
	}

}
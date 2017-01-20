import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * DecisionNode Interface used for QuestionNode 
 * and GuessNode classes
 * @author Dennis Chan
 * @author Linh Pham
 */
public interface DecisionNode {
	public int countObjects();
	public DecisionNode guess(Scanner in);
	public void write(FileWriter out) throws IOException;
}

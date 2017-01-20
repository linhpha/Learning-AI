import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *	LearningGenie class used to call the main methods
 * 	@author Dennis Chan
 * 	@author Linh Pham
 */
public class LearnigGenie {
	public static void main(String[] args) throws IOException {
		String cont = "yes";

		DecisionNode tree;
		Scanner in = new Scanner(System.in);
		File file = new File("/home/phamlinh/AI.txt");

		if (file.exists()){
			tree = new DecisionTree(file);
		} else {
			tree = new DecisionTree();
		}

		System.out.println("I am the learning genie!");
		System.out.println("I can figure out whatever you are thinking of by asking questions.");
		System.out.println("I know " +  tree.countObjects() + " thing(s)!");

		while (cont.equalsIgnoreCase("Yes")){
			System.out.println("\nThink of an object!");
			tree = tree.guess(in);

			System.out.print("\nDo you want to continue? ");
			cont = in.next();
			in.nextLine();
		}

		FileWriter out = new FileWriter("/home/phamlinh/AI.txt");
		tree.write(out);
		out.close(); 
	}
}

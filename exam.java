import java.util.Scanner;

public class exam {

	
	
	public static void main(String args[]) {
		int studentCount;
		Scanner readIn = new Scanner(System.in);
		System.out.println("Enter number of students");
		double studentScore;
		double highScore = 0;
		String studentHighScoreName = "";
		double total = 0;
		double average;
		String name;
		 studentCount = readIn.nextInt();  
		 for(int i=0; i < studentCount; i++) {
			 int j = i + 1;
			 System.out.println("Enter student " + j + " name");
			 name = readIn.next();
			 //System.out.println(name);
			 System.out.println("Enter " + name + "'s score");	
			 studentScore = readIn.nextDouble();
			 if(studentScore > highScore) {
				 highScore = studentScore;
				 studentHighScoreName = name;
			 }
			 total = total + studentScore;
		 }
		 average = total / studentCount;
		 average = Math.round((average * 1) * 10) / 10.0;
		 System.out.println("High Score is for " + studentHighScoreName + " at " + highScore);
		 System.out.println();
		 System.out.println("Average is " + average);
		 
	}
		
}

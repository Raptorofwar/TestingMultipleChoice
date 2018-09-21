import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class runningthing {

	//A quick test for the "answer of the day" theory, since I'm too lazy to do it mathematically.
	//Instead, have a simulation.
	//Type 0 or lower to break.
	//
	
	//assumes multiple-choice problem with 5 solutions.
	//To change number of solutions, change constant below.
	static int NUMPOSSSOLUTIONS=5;
	
	public static void main(String[] args) {
		while(true) {
			int allAnswersRandom=0;
			int allAnswersAOTD=0;
			Scanner reader = new Scanner(System.in);
			System.out.print("Number of test tries: ");
			int numberOfTestTries = reader.nextInt();
			if(numberOfTestTries<=0) {
				break;
			}
			int AOTDguess = ThreadLocalRandom.current().nextInt(1, NUMPOSSSOLUTIONS+1);
			for(int i=0;i<numberOfTestTries;i++) {
				if(questionRandomAnswer()) {
					allAnswersRandom++;
				}
				if(questionAOTD(AOTDguess)) {
					allAnswersAOTD++;
				}
			}
			System.out.println("RandomAnswer: "+allAnswersRandom);
			System.out.println("AOTDAnswer: "+allAnswersAOTD);
		}
	}
	
	//This is for if one is randomly guessing.
	public static boolean questionRandomAnswer() {
		int correctAnswer = ThreadLocalRandom.current().nextInt(1, NUMPOSSSOLUTIONS+1);
		int guess = ThreadLocalRandom.current().nextInt(1, NUMPOSSSOLUTIONS+1);
		if(correctAnswer==guess) {
			return true;
		}else {
			return false;
		}
	}
	
	//This is if one sticks with an answer.
	public static boolean questionAOTD(int guess) {
			int correctAnswer = ThreadLocalRandom.current().nextInt(1, NUMPOSSSOLUTIONS+1);
			if(correctAnswer==guess) {
				return true;
			}else {
				return false;
			}
	}
}
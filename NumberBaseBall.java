import java.util.Random;
import java.util.Scanner;

public class NumberBaseBall {
	
	Scanner userInput = new Scanner(System.in);

	private int baseBallNumber[] = {-1, -1, -1};
	private int userBallNumber[] = {-1, -1, -1};

	
	public boolean validatePlayerNumber(int userBallInput) {
		
		boolean check = true;
		
		// Validation Part
		if(userBallInput > 0 && userBallInput < 1000) {
			
			calculateUserBallNumber(userBallInput);
			System.out.println();
			check = false;
		} else {
			System.out.println("Invalid input Try Again!");
			System.out.println("Range is 0 ~ 999");
			System.out.println();
		}
		return check;
	}
	
	public boolean validateGame() {
		
		boolean game = true;
		
		if(baseBallNumber[0] == userBallNumber[0] && baseBallNumber[1] == userBallNumber[1] && baseBallNumber[2] == userBallNumber[2]) {
			System.out.println("You Got it!");
			game = false;
		}
		return game;
	}
	
	public void setBallNumber() {
		
		Random rNum = new Random();
		
		boolean check;
		
		// Generate random Integer 0 to 9
	
		for(int i = 0; i < baseBallNumber.length; i++) {
			
			while(true) {
				baseBallNumber[i] = rNum.nextInt(10);
				check = false;
				
				for(int j = 0; j < i; j++) {
					if(baseBallNumber[j] == baseBallNumber[i]) {
						check = true;
						break;
					}
					
					if(baseBallNumber[j] != baseBallNumber[i]) {
						check = false;
					}
				}
				
				if(!check) {
					break;
				}
			}
		}	
	}
	
	public void setPlayerNumber() {
		
		int userBallInput;
		boolean outerLoop = true;
		
		while(outerLoop) {	
			
			System.out.println("EX) 123, Range 0 ~ 999");
			System.out.print("Enter the Number: ");
			userBallInput = userInput.nextInt();
			
			outerLoop = validatePlayerNumber(userBallInput);
		}
	}
	
	public void calculateUserBallNumber(int userNumber) {
		
		int firstNum = (userNumber / 100); 
		int secondNum = (userNumber % 100 / 10); 
		int thirdNum = (userNumber % 100 % 10); 
		
		userBallNumber[0] = firstNum;
		userBallNumber[1] = secondNum;
		userBallNumber[2] = thirdNum;
	}
	
	
	public int calculateBall() {
		
		int ballCount = 0;
		
		if(userBallNumber[0] == baseBallNumber[1] || userBallNumber[0] == baseBallNumber[2] ) {
			ballCount = ballCount + 1;
		} if(userBallNumber[1] == baseBallNumber[0] || userBallNumber[1] == baseBallNumber[2]) {
			ballCount = ballCount + 1;
		} if(userBallNumber[2] == baseBallNumber[0] || userBallNumber[2] == baseBallNumber[1]) {
			ballCount = ballCount + 1;
		}
		
		if(ballCount == 0) {
			
		} else {
			System.out.println( ballCount + " Ball");
			System.out.println();
		}
		
		return ballCount;
	}
	
	public int calculateStrike() {
		
		int strikeCount = 0;
		
		if(userBallNumber[0] == baseBallNumber[0] ) {
			strikeCount = strikeCount + 1;
		} if (userBallNumber[1] == baseBallNumber[1]) {
			strikeCount = strikeCount + 1;
		} if (userBallNumber[2] == baseBallNumber[2]) {
			strikeCount = strikeCount + 1;
		}
		
		if(strikeCount == 0) {
			
		} else {
			System.out.println( strikeCount + " Strike!");	
			System.out.println();
		}
		
		return strikeCount;
	}
	
	public void calculatekOut() {
		
		int ballCount =	calculateBall();
		int strikeCount = calculateStrike();
	 
		if( (ballCount == 0) && (strikeCount == 0) ) {
			System.out.println("Out!");	
			System.out.println();
		}
	}
	
	public void game() {
		
		boolean outLoop = true;
		
		System.out.println("This is Number Base Ball Game");
		System.out.println();
		
		setBallNumber();
		

		while(outLoop) {
			
			setPlayerNumber();
			
			calculatekOut();
			outLoop = validateGame();
		}
		
		System.out.println("Base Ball Number: " + baseBallNumber[0] + " " + baseBallNumber[1] + " " + baseBallNumber[2]);
	}
}

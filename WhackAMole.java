import java.util.Random;
import java.util.Scanner;

public class WhackAMole {

	static int score = 0;
	static int molesLeft = 0;
	static int attemptsLeft;
	static Scanner userInput = new Scanner(System.in);	
	static Random rand = new Random();
	char[][] moleGrid;
	int numAttempts;	

	boolean place(int x, int y)
	{	
		moleGrid[x][y] = 'M';
		return true;
	}
	 void whack(int x, int y) {
		if(moleGrid[x][y] == 'M') {
			moleGrid[x][y] = 'W';
			score += 1;
			molesLeft = molesLeft + 1;
		}else {
			System.out.println("Miss...");
		}
		attemptsLeft -= 1;
	}
	static void printGrid(char[][] x)
	{
		for(int i = 0; i < x.length; i++)
		{
			for (int j = 0; j < x[i].length; j++)
			{
				System.out.print(x[i][j]);
			}
			System.out.println();
			
		}
	}
	static void printGridToUser(char[][] x)
	{
		for(int i = 0; i < x.length; i++)
		{
			for (int j = 0; j < x[i].length; j++)
			{
				if(x[i][j] == 'M') {
					System.out.print("*");
				}else {
				System.out.print(x[i][j]);
				}
			}
			System.out.println();			
		}
	}
	
	WhackAMole(int numAttempts, int gridDimension)
	{
		char[][] moleGrid = new char[gridDimension][gridDimension];
		this.numAttempts = numAttempts;
		this.attemptsLeft = numAttempts;
		this.molesLeft = 0;
		this.score = 0;
		this.moleGrid = moleGrid;
		for(int i = 0; i < moleGrid.length; i++)
		{
			for (int j = 0; j < moleGrid[i].length; j++)
			{
				moleGrid[i][j] = '*';
			}
		}

	}
	
	public static void main(String[] args) {
		WhackAMole moleGrid = new WhackAMole(50, 10);
		int l = 0;
		while(l < 10)
		{
			int w = rand.nextInt(9)+0;
			int f = rand.nextInt(9)+0;
			moleGrid.place(w,f);
			l++;
		}		
		System.out.println("There are "+ moleGrid.molesLeft + " moles left to hit in the game.");
		System.out.println("You have "+ moleGrid.attemptsLeft + " tries left to whack all the moles.");
		printGridToUser(moleGrid.moleGrid);
		System.out.println("Enter x y coordinates to make guesses. Input -1, -1 to end the game.");
		while(attemptsLeft > 0 && molesLeft < 10) {
		System.out.println("Enter x coordinate first: ");
		int x_guess = userInput.nextInt();
		System.out.println("Enter y coordinate: ");
		int y_guess = userInput.nextInt();
		if(x_guess == -1 && y_guess == -1) {
			printGrid(moleGrid.moleGrid);
			attemptsLeft = 0;
		}else {		
			moleGrid.whack(x_guess, y_guess);
		printGridToUser(moleGrid.moleGrid);
		System.out.println("There are "+ moleGrid.molesLeft + " moles left to hit in the game.");
		System.out.println("You have "+ moleGrid.attemptsLeft + " tries left to whack all the moles.");
		} 
		}
			System.out.println("The game is over");
			if(molesLeft == 10) {
				System.out.println("You have won!");
			}
			else {
				System.out.println("You have lost.... Better luck next time");
			}
		
	}

}

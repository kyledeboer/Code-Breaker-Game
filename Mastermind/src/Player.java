import java.util.Scanner;

public class Player {
	private Board board;
	public Player(Board boardx) {
		board=boardx;
	}
	public int guess(int attempt) {
		char guess[]=new char[5];
		Scanner scan= new Scanner(System.in);
		for(int i=0; i<5; i++) {
			System.out.printf("Please enter color for slot %s", i+1);
			char color=scan.next().charAt(0);
			guess[i]=color;
		}
		board.updateBoard(attempt, guess);
		int x=board.checkGuess(attempt);
		if(x!=0)return 1;
		return 0;
	}

}

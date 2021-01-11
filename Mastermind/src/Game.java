import java.io.IOException;

public class Game {
	private Board theBoard;
	private Player thePlayer;
	private int attemptNo;
	
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.run();
	}
	
	public void run() {
		IntroGUI g= new IntroGUI("Code Breaker");
		theBoard= new Board();
		thePlayer= new Player(theBoard);
		attemptNo=0;
		while(attemptNo<12) {
			int x=thePlayer.guess(attemptNo);
			if(x!=0) {
				System.out.print("\n\n XXXXXXXXX YOU WIN! XXXXXXXXX\n");
				theBoard.printCorrectCode();
				System.exit(1);
			}
			attemptNo++;
			System.out.print(theBoard.Display());
		}
		if(attemptNo==12) {
			System.out.print("\n\n XXXXXXXXX YOU LOSE! XXXXXXXXX");
			System.out.print("\n\nThe correct code is: ");
			theBoard.printCorrectCode();
			System.exit(1);
		}
	}
}

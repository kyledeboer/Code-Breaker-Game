import java.util.Random;
import java.util.Arrays;

public class Board implements Color{
	char theBoard[][];
    private char correctCombo[];
	private char clues[][];
	//private int attemptNo;
	
	public Board() {
		theBoard = new char[12][];
		for (int i = 0; i < 12; i++) {
			theBoard[i] = new char[5];
			for (int j = 0; j < 5; j++)
				theBoard[i][j] = EMPTY;
		}
		clues = new char[12][];
		for(int i =0; i < 12; i++) {
			clues[i] = new char[5];
			for(int j = 0; j < 5; j++)
				clues[i][j] = EMPTY;
		}
		correctCombo= new char[5];
		GenerateRandomCode();
		
	}
	
	private void GenerateRandomCode() {
		Random ran= new Random();
		int bound= 7;
		for( int i=0; i<5; i++) {
			correctCombo[i]= NumberToColor(ran.nextInt(bound));
		}
	}

	private char NumberToColor(int random) {
		if(random==0) return RED;
		if(random==1) return BLUE;
		if(random==2) return YELLOW;
		if(random==3) return ORANGE;
		if(random==4) return BLACK;
		if(random==5) return WHITE;
		if(random==6) return PURPLE;
		if(random==7) return GREEN;
		
		return BLACK;
	}

	public String Display() {
		String str = "\n\n  CLUES	    GUESS	\n\n";
		for(int i =0; i<12; i++) {
			str+="| "+clues[i][0]+clues[i][1]+clues[i][2]+clues[i][3]+clues[i][4]+"  |";
			str+="  "+theBoard[i][0]+theBoard[i][1]+theBoard[i][2]+theBoard[i][3]+theBoard[i][4]+"  |";
			str+="\n";
		}
		str+="\n";
		return str;
	}
    

	public int checkGuess(int attempt){
		int whiteCount=0;
		int blackCount=0;
		
		char copySolution[]=new char[5];
		char copyGuess[]=new char[5];
		//copySolution=theBoard[attempt];
		copySolution = Arrays.copyOf(correctCombo, 5);
		copyGuess = Arrays.copyOf(theBoard[attempt], 5);
		
		
		for(int i=0; i< 5; i++) {
			if(theBoard[attempt][i]==copySolution[i]) {
				blackCount++;
				copyGuess[i]=EMPTY;
				copySolution[i]=EMPTY;
				
			}
		}
		for(int i=0; i<5; i++) {
			if(checkIfInGuess(copyGuess[i], copySolution)!=-1 && copyGuess[i]!=EMPTY) {
				whiteCount++;
				System.out.printf("%s \n", copyGuess[i]);
				copySolution[checkIfInGuess(copyGuess[i], copySolution)]=EMPTY;
			}
		}
		//System.out.printf(whiteCount+" "+blackCount+"\n");
		if(blackCount==5)return 1;
		int count=0;
		while(whiteCount>0) {
			clues[attempt][count]='W';
			count++;
			whiteCount--;
		}
		while(blackCount>0) {
			clues[attempt][count]='X';
			count++;
			blackCount--;
		}
		return 0;
		
	}
	
	public void printCorrectCode() {
		System.out.print(correctCombo);
	}
	
	public int checkIfInGuess(char color, char[] copy) {
		for(int i=0; i<5; i++) {
			if(copy[i]==color) return i;
		}
		return -1;
	}

	public void updateBoard(int attempt, char[] guess) {
		for(int i=0; i<5; i++) {
			theBoard[attempt][i]=guess[i];
		}
		
	}
}

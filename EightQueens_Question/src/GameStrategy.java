public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		
		return cellId%8;
//		return 0;	// just for the heck of it
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		return ((cellId-(cellId%8))/8);
//		return 0;	// just for the heck of it
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		/*
			WRITE YOUR LOGIC HERE...............................

		*/
		for(int i=0;i<8;i++) {
			if(row+i<8 && col+i<8 && placedQueens[row+i][col+i]==true) {
				isValid=false;
				break;
			}
			else if(row-i>=0 && col-i>=0 && placedQueens[row-i][col-i]==true) {
				isValid=false;
				break;
			}
			else if(row+i<8 && col-i>=0 && placedQueens[row+i][col-i]==true) {
				isValid=false;
				break;
			}
			else if(row-i>=0 && col+i<8 && placedQueens[row-i][col+i]==true) {
				isValid=false;
				break;
			}
			if(col+i<8 && placedQueens[row][col+i]==true) {
				isValid=false;
				break;
			}
			else if(col-i>=0 && placedQueens[row][col-i]==true) {
				isValid=false;
				break;
			}
			else if(row+i<8 && placedQueens[row+i][col]==true) {
				isValid=false;
				break;
			}
			else if(row-i>=0 && placedQueens[row-i][col]==true) {
				isValid=false;
				break;
			}
		
			}
		if(isValid==true) {
			placedQueens[row][col]=true;
			numQueens++;
		}
		return isValid;
	}
}















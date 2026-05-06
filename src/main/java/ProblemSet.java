/**
 * Option 1: The GamePiece and GameBoard classes
 * @author Jason Wu
 */
public class ProblemSet {
/**
 * runs and test code to see if it works
 * @param args commands line of arguments
 */	
	public static void main(String args[]) {
		GamePiece piece1 = new GamePiece("Pawn" , "Red", 3);
		GamePiece piece2 = new GamePiece("Boot", "Green", 1);
		GamePiece piece3 = new GamePiece("Car", "Yellow", 5);
		GamePiece piece4 = new GamePiece("Mouse", "Purple", 4);

		GameBoard board = new GameBoard();
		System.out.println(board);

		System.out.println("Placing pieces on:");
		board.placePiece(piece1, 3, 2);
		board.placePiece(piece2, 3, 3);
		board.placePiece(piece3, 4, 1);
		board.placePiece(piece4, 1, 2);
		System.out.println(board);

		System.out.println("Testing hasPiece:");
		System.out.println(board.hasPiece(3, 2));
		System.out.println(board.hasPiece( 0, 2));

		System.out.println("Testing removePiece:");
		board.removePiece(3,2);
		System.out.println(board.hasPiece(3,2));

		System.out.println("Testing equals:");
		GamePiece piece5 = new GamePiece("Car", "Yellow", 5);
		System.out.println(piece1.equals(piece5));
		System.out.println(piece3.equals(piece5));

		System.out.println("Testing out of bounds:");
		try { 
			board.getTile(6, 6);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Testing null:");
		try { 
			board.placePiece(null, 0,0);
		} catch (NullPointerException e) {
		System.out.println("Error: " + e.getMessage());

		}
		System.out.println("Testing empty tiles:");
			try { 
				board.removePiece(1, 1);
			} catch (NullPointerException e) {
				System.out.println("Error: " + e.getMessage());
	
		}
	}
	

	static class GamePiece {
		private String label;
		private String color;
		private int pointValue;
/**
 * this creates a new game piece with label with color and point
 * @param label name of a piece like Pawn or Boot
 * @param color color of a piece like Yellow or Red
 * @param pointValue score value of a piece like score of 1 or score of 3
 */
	public GamePiece(String label, String color, int pointValue) {
		this.label = label;
		this.color = color;
		this.pointValue = pointValue;
	}
	//Getters
	public String getLabel() {
		return label;
	}

	public String getColor() {
		return color;
	}

	public int getPointValue() {
		return pointValue;
	}
@Override
	public String toString() {
		return color + " " + label;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if(obj == null || getClass() != obj.getClass())
			return false;
		GamePiece other = (GamePiece) obj;
		return this.pointValue == other.pointValue
				&& this.label.equals(other.label) && this.color.equals(other.color);
	}
}
	static class GameBoard {
		private String[][] tiles;
		private GamePiece[][] pieces;

/**
 * this creates a gameboard using a layout that is given
 * @param layout that holds tiles types
 */
		public GameBoard(String[][] layout) {
			tiles = layout;
			pieces = new GamePiece[layout.length][layout[0].length];
		}
		
		public GameBoard() {
    	tiles = new String[5][5];
   	 	pieces = new GamePiece[5][5];

    	for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
          // number of tiles from 1-25  
            int myTile = (row * 5) + col + 1;

            if (myTile == 1) {
                tiles[row][col] = "Start";
            } else if (myTile == 25) {
                tiles[row][col] = "End";
            } else if (myTile % 6 == 0) {
                tiles[row][col] = "Penalty";
            } else if (myTile % 4 == 0) {
                tiles[row][col] = "Bonus";
            } else {
                tiles[row][col] = "Empty";
            }
        }
    }
}
		public int getRows() {
		return tiles.length;
	}

		public int getCols() {
		return tiles[0].length;
	}

	public String getTile(int row, int col) {
		if (row < 0 || col < 0 || row >= getRows() || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("out of bounds");

		} 
		return tiles[row][col];
	}

	public void setTile(int row, int col, String type) {
		if (row < 0 || col < 0 || row >= getRows() || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("out of bounds");

		}
		tiles[row][col] = type;
	}

	// places a piece on board
	public void placePiece(GamePiece piece, int row, int col) {
		if (piece == null) {
			throw new NullPointerException("piece is null");
	}
		 if (row < 0 || col < 0 || row >= getRows() || col >= getCols()) {
		throw new ArrayIndexOutOfBoundsException("out of bounds");
		 }
		pieces[row][col] = piece;
	}

	// removes piece from the board and returns it
	public GamePiece removePiece(int row, int col) {
		if (row < 0 || col < 0 || row >= getRows() || col >= getCols()) {
		throw new ArrayIndexOutOfBoundsException("out of bounds");
		}
		if (pieces[row][col] == null) {
		throw new NullPointerException("no piece is present");
		}
		GamePiece temp = pieces[row][col];
		pieces[row][col] = null;
		return temp;
	} 

	public GamePiece getPiece(int row, int col) {
		if (row < 0 || col < 0 || row >= getRows() || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("out of bounds");
		}
		return pieces[row][col];
	}
	
	// checks if tile has a piece
	public boolean hasPiece(int row, int col) {
		if (row < 0 || col < 0 || row >= getRows() || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("out of bounds");
		}
		return pieces[row][col] != null;
	}
	// prints board
	@Override
	public String toString() {
		String result = "";
		for (int row = 0; row < getRows(); row++) {
			for (int col = 0; col < getCols(); col++) {
				result += tiles[row][col];
				if (pieces[row][col] != null) {
					result += "(" + pieces[row][col] + ")";

				}
				if (col < getCols() - 1) {
					result += " | ";
				}
				
			}
			result += "\n";
		}
		return result;
	}

}
}
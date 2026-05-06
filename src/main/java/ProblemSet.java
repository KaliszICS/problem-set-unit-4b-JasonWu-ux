public class ProblemSet {

	public static void main(String args[]) {

	}

	public class GamePiece {
		private String label;
		private String color;
		private int pointValue;

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

	public String toString() {
		return color + " " + label;
	}

	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if(obj == null || getClass() != obj.getClass())
			return false;
		GamePiece other = (GamePiece ) obj;
		return this.pointValue == other.pointValue
				&& this.label.equals(other.label) && this.color.equals(other.color);
	}
}
	public class GameBoard {
		private String[][] tiles;
		private GamePiece[][] pieces;

		public GameBoard(String[][] layout) {
			tiles = layout;
			pieces = new GamePiece[layout.length][layout[0].length];
		}
		public GameBoard() {
    	tiles = new String[5][5];
   	 	pieces = new GamePiece[5][5];

    	for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
            
            int NumberOfTile = (row * 5) + col + 1;

            if (NumberOfTile == 1) {
                tiles[row][col] = "Start";
            } else if (NumberOfTile == 25) {
                tiles[row][col] = "End";
            } else if (NumberOfTile % 6 == 0) {
                tiles[row][col] = "Penalty";
            } else if (NumberOfTile % 4 == 0) {
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
		if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("Out of Bounds");

		} 
		return tiles[row][col];
	}
	public void setTile(int row, int col, String type) {
		if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("Out of Bounds");

		}
		tiles[row][col] = type;
	}
	public void placePiece(GamePiece piece, int row, int col) {
		if (piece == null) {
			throw new NullPointerException("piece is null");
	}
		 if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
		throw new ArrayIndexOutOfBoundsException("Out of Bounds");
		 }
		pieces[row][col] = piece;
	}
	public GamePiece removePiece(int row, int col) {
		if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
		throw new ArrayIndexOutOfBoundsException("Out of Bounds");
		}
		if (pieces[row][col] == null) {
		throw new NullPointerException("no piece is present");
		}
		GamePiece temp = pieces[row][col];
		pieces[row][col] = null;
		return temp;
	} 
	public GamePiece getPiece(int row, int col) {
		if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("Out of Bounds");
		}
		return pieces[row][col];
	}
	public boolean hasPiece(int row, int col) {
		if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
			throw new ArrayIndexOutOfBoundsException("Out of Bounds");
		}
		return pieces[row][col] != null;
	}
}
}

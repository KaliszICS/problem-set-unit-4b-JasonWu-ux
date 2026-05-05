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
            
            int tileNumber = (row * 5) + col + 1;

            if (tileNumber == 1) {
                tiles[row][col] = "Start";
            } else if (tileNumber == 25) {
                tiles[row][col] = "End";
            } else if (tileNumber % 6 == 0) {
                tiles[row][col] = "Penalty";
            } else if (tileNumber % 4 == 0) {
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
}
}
	


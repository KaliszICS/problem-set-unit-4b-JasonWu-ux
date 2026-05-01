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
		GamePiece other == (GamePiece ) obj;
		return this.pointValue == other.pointValue
				&& this.label.equals(other.label) && this.color.equals(other.color);
	}
}



class label 
	private String Pawn;
	private String Boot;
	private String Car;
	private String Mouse;




	colors of piece  	piece pawn, boot,car, mouse
	Red
	Green
	Purple
	Yellow


	


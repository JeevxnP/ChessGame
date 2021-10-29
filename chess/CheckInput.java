package chess;

public class CheckInput {
	
	//This method requires your input
	public boolean checkCoordinateValidity(String input){
		return input.matches("^[1-8][a-h]$");
	}
}

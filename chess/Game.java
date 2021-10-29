package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){

		// Sets up turn system
		String[] turns = new String[] {"White","Black"};
		int turnNumber = 0;
		int turnCalculation;

		// Variables required for user input
		Console keyboardConsole = System.console();
		CheckInput check = new CheckInput();
		String pieceLocation;
		String pieceDestination;
		boolean validInput;
		String[] split;
		int[] pieceCoords = {0,0};
		int[] destinationCoords = {0,0};

		// Variable to store the piece the user has selected to move
		Piece movingPiece;

		while (!gameEnd){
			// Current turn output
			turnCalculation = turnNumber % 2;
			System.out.println("\n------ " + turns[turnCalculation] + "s move ------");

			// User piece selection
			validInput = false;
			do {
				// Gets and validates the user input for origin
				pieceLocation = keyboardConsole.readLine("\nEnter origin: ");
				validInput = check.checkCoordinateValidity(pieceLocation);

				// Checks for player resignation
				if (pieceLocation.equals("END")){
					gameEnd = true;
					System.out.println("\n\n" + turns[turnCalculation] + " resigned!");
					turnCalculation = (turnNumber+1) % 2;
					break;
				}

				// Origin on board enterred
				else if (validInput == true){

					// Converts origin to correct format for processing
					split = pieceLocation.split("");
					pieceCoords[0] = Integer.parseInt(split[0]) - 1;
					switch (split[1]){
						case "a":
							pieceCoords[1] = 0;
							break;
						case "b":
							pieceCoords[1] = 1;
							break;
						case "c":
							pieceCoords[1] = 2;
							break;
						case "d":
							pieceCoords[1] = 3;
							break;
						case "e":
							pieceCoords[1] = 4;
							break;
						case "f":
							pieceCoords[1] = 5;
							break;
						case "g":
							pieceCoords[1] = 6;
							break;
						case "h":
							pieceCoords[1] = 7;
							break;
					}

					// Checks if their a piece of the player's colour on the origin square selected
					if (Board.hasPiece(pieceCoords[0],pieceCoords[1])){
						if (Board.getPiece(pieceCoords[0],pieceCoords[1]).getColour().toString().equals(turns[turnCalculation].toUpperCase())){
							System.out.println("'" + pieceLocation + "' is a valid origin square!");	// Valid input confirmation to the user

							// Gets and validates the user input for destination
							validInput = false;
							pieceDestination = keyboardConsole.readLine("\nEnter destination: ");
							validInput = check.checkCoordinateValidity(pieceDestination);

							// Destination on board enterred
							if (validInput == true){

								// Converts destination to correct format for processing
								split = pieceDestination.split("");
								destinationCoords[0] = Integer.parseInt(split[0]) - 1;
								switch (split[1]){
									case "a":
										destinationCoords[1] = 0;
										break;
									case "b":
										destinationCoords[1] = 1;
										break;
									case "c":
										destinationCoords[1] = 2;
										break;
									case "d":
										destinationCoords[1] = 3;
										break;
									case "e":
										destinationCoords[1] = 4;
										break;
									case "f":
										destinationCoords[1] = 5;
										break;
									case "g":
										destinationCoords[1] = 6;
										break;
									case "h":
										destinationCoords[1] = 7;
										break;
								}

								// Checks if the piece selected can move to the destination
								validInput = false;
								movingPiece = Board.getPiece(pieceCoords[0],pieceCoords[1]);
								validInput = movingPiece.isLegitMove(pieceCoords[0],pieceCoords[1],destinationCoords[0],destinationCoords[1]);
								
								// Moves piece, updates gameEnd (set to true if the king is taken) and shows the updated board
								if (validInput == true){
									gameEnd = Board.movePiece(pieceCoords[0],pieceCoords[1],destinationCoords[0],destinationCoords[1],movingPiece);
									Board.printBoard();
								}
								else
									System.out.println("The piece selected can't make this move.");
							}
							else
								System.out.println("'" + pieceDestination + "' is an invalid destination square.");
						}
						else{
							validInput = false;
							System.out.println("'" + pieceLocation + "' contains a piece of the wrong colour.");
						}
					}
					else{
						validInput = false;
						System.out.println("'" + pieceLocation + "' doesn't have a piece.");
					}
				}
				else
					System.out.println("'" + pieceLocation + "' is an invalid origin square.");
			} while (validInput == false);

			// Win message if the game has been ended (either won or resigned)
			if (gameEnd == true)
				System.out.println("\nGAME OVER! " + turns[turnCalculation] + " wins!!!");

			// Increments the turn number for the next turn
			turnNumber++;
		}		
	}
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}

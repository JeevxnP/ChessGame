package chess;

public class Pawn extends Piece{	
	public Pawn (PieceColour p){
		if (p == PieceColour.WHITE)
			setSymbol("♙");
		else
			setSymbol("♟︎");
		colour = p;
	}

	@Override
	public boolean isLegitMove(int iOld, int jOld, int iNew, int jNew){
		// Checking for the destination being the same as the start position
		if ((iOld == iNew) && (jOld == jNew))
			return false;

		// Other checks
		else{
			PieceColour p = getColour();
			if (p == PieceColour.WHITE){
				// White pawn on start position (can move 1 or 2 spaces forwards)
				if (iOld == 6){
					// If it's moving in a straight line
					if (jOld == jNew){
						if ((iOld-iNew) == 1){
							if (Board.hasPiece(iNew,jNew))
								return false;
							else
								return true;
						}
						else if ((iOld-iNew) == 2){
							if (Board.hasPiece(5,jNew))
								return false;
							else if (Board.hasPiece(4,jNew))
								return false;
							else
								return true;
						}
						else
							return false;
					}
					// Taking pieces diagonally
					else if ((Board.hasPiece(iNew,jNew)) && (Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour())){
						// Diagonal by -1
						if ((jOld-jNew) == -1){
							if ((iOld-iNew) == 1)
								return true;
							else
								return false;
						}
						// Diagonal by 1
						else if ((jOld-jNew) == 1){
							if ((iOld-iNew) == 1)
								return true;
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;

				}
				// White pawn at any other position (can only move 1 space forward)
				else{
					// If it's moving in a straight line
					if (jOld == jNew){
						if ((iOld-iNew) == 1){
							if (Board.hasPiece(iNew,jNew))
								return false;
							else
								return true;
						}
						else
							return false;
					}
					// Taking pieces diagonally
					else if ((Board.hasPiece(iNew,jNew)) && (Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour())){
						// Diagonal by -1
						if ((jOld-jNew) == -1){
							if ((iOld-iNew) == 1)
								return true;
							else
								return false;
						}
						// Diagonal by 1
						else if ((jOld-jNew) == 1){
							if ((iOld-iNew) == 1)
								return true;
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
			}
			else{
				// Black pawn on start position (can move 1 or 2 spaces forwards)
				if (iOld == 1){
					// If it's moving in a straight line
					if (jOld == jNew){
						if ((iNew-iOld) == 1){
							if (Board.hasPiece(iNew,jNew))
								return false;
							else
								return true;
						}
						else if ((iNew-iOld) == 2){
							if (Board.hasPiece(2,jNew))
								return false;
							else if (Board.hasPiece(3,jNew))
								return false;
							else
								return true;
						}
						else
							return false;
					}
					// Taking piece diagonally
					else if ((Board.hasPiece(iNew,jNew)) && (Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour())){
						// Diagonal by -1
						if ((jOld-jNew) == -1){
							if ((iNew-iOld) == 1)
								return true;
							else
								return false;
						}
						// Diagonal by 1
						else if ((jOld-jNew) == 1){
							if ((iNew-iOld) == 1)
								return true;
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
				// Black pawn at any other position (can only move 1 space forward)
				else{
					// If it's moving in a straight line
					if (jOld == jNew){
						if ((iNew-iOld) == 1){
							if (Board.hasPiece(iNew,jNew))
								return false;
							else
								return true;
						}
						else
							return false;
					}
					else if ((Board.hasPiece(iNew,jNew)) && (Board.getPiece(iOld,jOld).getColour() != Board.getPiece(iNew,jNew).getColour())){
						// Diagonal by -1
						if ((jOld-jNew) == -1){
							if ((iNew-iOld) == 1)
								return true;
							else
								return false;
						}
						// Diagonal by 1
						else if ((jOld-jNew) == 1){
							if ((iNew-iOld) == 1)
								return true;
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
			}
		}
	}
}

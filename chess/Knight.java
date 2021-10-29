package chess;

public class Knight extends Piece{
	public Knight (PieceColour p){
		if (p == PieceColour.WHITE)
			setSymbol("♘");
		else
			setSymbol("♞");
		colour = p;
	}

	@Override
	public boolean isLegitMove(int iOld, int jOld, int iNew, int jNew){
		// Checking for same colour on the destination
		if ((Board.hasPiece(iNew,jNew)) && (Board.getPiece(iOld,jOld).getColour() == Board.getPiece(iNew,jNew).getColour()))
				return false;
		
		// Checking for the destination being the same as the start position
		else if ((iOld == iNew) && (jOld == jNew))
			return false;

		// All movement combinations for knight (2 squares on 1 axis and 1 square on the other)
		else if (((iOld+2) == iNew) && ((jOld+1) == jNew))
			return true;
		else if (((iOld+2) == iNew) && ((jOld-1) == jNew))
			return true;
		else if (((iOld-2) == iNew) && ((jOld+1) == jNew))
			return true;
		else if (((iOld-2) == iNew) && ((jOld-1) == jNew))
			return true;
		else if (((iOld+1) == iNew) && ((jOld+2) == jNew))
			return true;
		else if (((iOld+1) == iNew) && ((jOld-2) == jNew))
			return true;
		else if (((iOld-1) == iNew) && ((jOld+2) == jNew))
			return true;
		else if (((iOld-1) == iNew) && ((jOld-2) == jNew))
			return true;

		// Doesn't match any of the combinations above
		else
			return false;
	}
}

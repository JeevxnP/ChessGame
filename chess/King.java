package chess;

public class King extends Piece{
	public King (PieceColour p){
		if (p == PieceColour.WHITE)
			setSymbol("♔");
		else
			setSymbol("♚");
		colour = p;
	}

	@Override
	public boolean isLegitMove(int iOld, int jOld, int iNew, int jNew){
		// Calculates the distances the king travels alogn each axis
		int distanceI = iNew - iOld;
		int distanceJ = jNew - jOld;

		// Checking for the destination being the same as the start position
		if ((iOld == iNew) && (jOld == jNew))
			return false;

		// Checks if the king has moved more than 1 sqaure in any direction
		else if ((-1 <= distanceI) && (distanceI <= 1) && (-1 <= distanceJ) && (distanceJ <= 1))
			// Checks if there is a piece of the same colour on the destination square (if there is one)
			if ((Board.hasPiece(iNew,jNew)) && (Board.getPiece(iOld,jOld).getColour() == Board.getPiece(iNew,jNew).getColour()))
				return false;
			else
				return true;
		else
			return false;
	}
}

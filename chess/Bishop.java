package chess;

public class Bishop extends Piece{
	public Bishop (PieceColour p){
		if (p == PieceColour.WHITE)
			setSymbol("♗");
		else
			setSymbol("♝");
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

		// Checks if it has moved an equal number of squares horizontally as it has done vertically
		else if (Math.abs(iOld-iNew) == Math.abs(jOld-jNew)){
			// Checks for a piece in the way of movement for each movement direction
			if ((iOld < iNew) && (jOld < jNew)){
				while ((iOld != (iNew-1)) && (jOld != (jNew-1))){
					iOld++;
					jOld++;
					if (Board.hasPiece(iOld,jOld))
						return false;
				}
				return true;
			}

			else if ((iOld < iNew) && (jOld > jNew)){
				while ((iOld != (iNew-1)) && (jOld != (jNew+1))){
					iOld++;
					jOld--;
					if (Board.hasPiece(iOld,jOld))
						return false;
				}
				return true;
			}

			else if ((iOld > iNew) && (jOld < jNew)){
				while ((iOld != (iNew+1)) && (jOld != (jNew-1))){
					iOld--;
					jOld++;
					if (Board.hasPiece(iOld,jOld))
						return false;
				}
				return true;
			}

			else{
				while ((iOld != (iNew+1)) && (jOld != (jNew+1))){
					iOld--;
					jOld--;
					if (Board.hasPiece(iOld,jOld))
						return false;
				}
				return true;
			}
		}
		else
			return false;
	}
}

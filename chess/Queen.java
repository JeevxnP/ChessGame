package chess;

public class Queen extends Piece{
	public Queen (PieceColour p){
		if (p == PieceColour.WHITE)
			setSymbol("♕");
		else
			setSymbol("♛");
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

		// Bishop logic
		else if (Math.abs(iOld-iNew) == Math.abs(jOld-jNew)){
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
		

		// Rook logic
		else if (iOld == iNew){
			if (jOld < jNew){
				for (int j = jOld+1; j < jNew; j++){
					if (Board.hasPiece(iOld,j)){
						return false;
					}
				}
				return true;
			}
			else
				for (int j = jOld-1; j > jNew; j--){
					if (Board.hasPiece(iOld,j)){
						return false;
					}
				}
				return true;
		}

		else if (jOld == jNew){
			if (iOld < iNew){
				for (int i = iOld+1; i < iNew; i++){
					if (Board.hasPiece(i,jOld)){
						return false;
					}
				}
				return true;
			}
			else
				for (int i = iOld-1; i > iNew; i--){
					if (Board.hasPiece(i,jOld)){
						return false;
					}
				}
				return true;
		}
		else
			return false;
	}
}
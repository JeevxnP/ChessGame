package chess;

public class Rook extends Piece{
	public Rook (PieceColour p){
		if (p == PieceColour.WHITE)
			setSymbol("♖");
		else
			setSymbol("♜");
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

		// Moving horizontally
		else if (iOld == iNew){
			// Checks for a piece inbetween the piece and the destination
			if (jOld < jNew){	// Moving right
				for (int j = jOld+1; j < jNew; j++){
					if (Board.hasPiece(iOld,j)){
						return false;
					}
				}
				return true;
			}
			else 	// Moving left
				for (int j = jOld-1; j > jNew; j--){
					if (Board.hasPiece(iOld,j)){
						return false;
					}
				}
				return true;
		}

		// Moving vertically
		else if (jOld == jNew){
			// Checks for a piece inbetween the piece and the destination
			if (iOld < iNew){	// Moving up
				for (int i = iOld+1; i < iNew; i++){
					if (Board.hasPiece(i,jOld)){
						return false;
					}
				}
				return true;
			}
			else 	// Moving down
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

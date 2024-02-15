package chess;

import java.util.ArrayList;


class ReturnPiece {
	static enum PieceType {WP, WR, WN, WB, WQ, WK, 
		            BP, BR, BN, BB, BK, BQ};
	static enum PieceFile {a, b, c, d, e, f, g, h};
	
	PieceType pieceType;
	PieceFile pieceFile;
	int pieceRank;  // 1..8
	public String toString() {
		return ""+pieceFile+pieceRank+":"+pieceType;
	}
	public boolean equals(Object other) {
		if (other == null || !(other instanceof ReturnPiece)) {
			return false;
		}
		ReturnPiece otherPiece = (ReturnPiece)other;
		return pieceType == otherPiece.pieceType &&
				pieceFile == otherPiece.pieceFile &&
				pieceRank == otherPiece.pieceRank;
	}
}

class ReturnPlay {
	enum Message {ILLEGAL_MOVE, DRAW, 
				  RESIGN_BLACK_WINS, RESIGN_WHITE_WINS, 
				  CHECK, CHECKMATE_BLACK_WINS,	CHECKMATE_WHITE_WINS, 
				  STALEMATE};
	
	ArrayList<ReturnPiece> piecesOnBoard;
	Message message;
}

public class Chess {
	enum Player { white, black }
	public static ReturnPiece[][] board = new ReturnPiece[8][8];
	/**
	 * Plays the next move for whichever player has the turn.
	 * 
	 * @param move String for next move, e.g. "a2 a3"
	 * 
	 * @return A ReturnPlay instance that contains the result of the move.
	 *         See the section "The Chess class" in the assignment description for details of
	 *         the contents of the returned ReturnPlay instance.
	 */
	public static boolean white = true;
	public static ReturnPlay play(String move) {
		if (move.equals("reset")){
			start();
			ReturnPlay temp = generateReturnPlay();
			temp.message = null;
			return temp;
			
		}


		/* FILL IN THIS METHOD */
		if (white){
			if (!Helper.isWhitePiece(Helper.getRank(move), Helper.getFile(move))){
				ReturnPlay temp = generateReturnPlay();
			temp.message = ReturnPlay.Message.ILLEGAL_MOVE;
			System.out.println(white);
			return temp;
			}
		}
		else{
			if (!Helper.isBlackPiece(Helper.getRank(move), Helper.getFile(move))){
				ReturnPlay temp = generateReturnPlay();
			temp.message = ReturnPlay.Message.ILLEGAL_MOVE;
			System.out.println(white);
			return temp;
		}
	}
	if (Helper.getSquare(Helper.getRank(move), Helper.getFile(move)).pieceType == null){
		ReturnPlay temp = generateReturnPlay();
			temp.message = ReturnPlay.Message.ILLEGAL_MOVE;
			return temp;
	}
		if (!Legal.isLegal(move)){
			ReturnPlay temp = generateReturnPlay();
			temp.message = ReturnPlay.Message.ILLEGAL_MOVE;
			return temp;
		}
		movePiece(move);
		ReturnPlay temp = generateReturnPlay();
		white = !white;
		/* FOLLOWING LINE IS A PLACEHOLDER TO MAKE COMPILER HAPPY */
		/* WHEN YOU FILL IN THIS METHOD, YOU NEED TO RETURN A ReturnPlay OBJECT */


		return temp;
	}
	public static ReturnPlay generateReturnPlay(){
		ReturnPlay temp = new ReturnPlay();
		temp.message = null;
		temp.piecesOnBoard = new ArrayList<>();
		for (int i = 0; i < 8; i++){
			for (int j = 0; j <8; j++){
				if (board[i][j].pieceType != null){
			temp.piecesOnBoard.add(board[i][j]);
				}
			}
		}
		return temp;
	}
	
	/**
	 * This method should reset the game, and start from scratch.
	 */
	public static void start() {
		white = true;
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				board[i][j] = new ReturnPiece();
			}
			
		}
		for (int i = 0; i <8; i++){
			for (int j = 0; j < 8; j++){
				board[i][j].pieceRank = i +1;
				switch (j) {
					case 0: board[i][j].pieceFile = ReturnPiece.PieceFile.a; break;
					case 1: board[i][j].pieceFile = ReturnPiece.PieceFile.b; break;
					case 2: board[i][j].pieceFile = ReturnPiece.PieceFile.c; break;
					case 3: board[i][j].pieceFile = ReturnPiece.PieceFile.d; break;
					case 4: board[i][j].pieceFile = ReturnPiece.PieceFile.e; break;
					case 5: board[i][j].pieceFile = ReturnPiece.PieceFile.f; break;
					case 6: board[i][j].pieceFile = ReturnPiece.PieceFile.g; break;
					case 7: board[i][j].pieceFile = ReturnPiece.PieceFile.h; break;
					default:
			}
		
		}
	}
	board[0][0].pieceType = ReturnPiece.PieceType.WR; board[0][1].pieceType = ReturnPiece.PieceType.WN;
	board[0][2].pieceType = ReturnPiece.PieceType.WB; board[0][3].pieceType = ReturnPiece.PieceType.WQ;
	board[0][4].pieceType = ReturnPiece.PieceType.WK; board[0][5].pieceType = ReturnPiece.PieceType.WB; 
	board[0][6].pieceType = ReturnPiece.PieceType.WN; board[0][7].pieceType = ReturnPiece.PieceType.WR;
	
	for (int i = 0; i <8; i++){
		board[1][i].pieceType = ReturnPiece.PieceType.WP;
	}
	
	board[7][0].pieceType = ReturnPiece.PieceType.BR; board[7][1].pieceType = ReturnPiece.PieceType.BN;
	board[7][2].pieceType = ReturnPiece.PieceType.BB; board[7][3].pieceType = ReturnPiece.PieceType.BQ;
	board[7][4].pieceType = ReturnPiece.PieceType.BK; board[7][5].pieceType = ReturnPiece.PieceType.BB; 
	board[7][6].pieceType = ReturnPiece.PieceType.BN; board[7][7].pieceType = ReturnPiece.PieceType.BR;
	
	for (int i = 0; i <8; i++){
		board[6][i].pieceType = ReturnPiece.PieceType.BP;
	}
		/* FILL IN THIS METHOD */
}



public static void movePiece( String move ){
	ReturnPiece.PieceType piece = Helper.curPieceType(move);
	int initial_file = move.charAt(0) - 'a';
	int initial_rank = Integer.parseInt(move.substring(1,2))-1;

	int final_file = move.charAt(3) - 'a';
	int final_rank = Integer.parseInt(move.substring(4, 5)) -1;

	board[initial_rank][initial_file].pieceType = null;
	board[final_rank][final_file].pieceType = piece;
}

}
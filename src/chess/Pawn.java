package chess;

import chess.ReturnPiece.PieceFile;
import chess.ReturnPiece.PieceType;

public class Pawn {
    
    public static boolean isLegalPawnWhite(String move){ //determines if a white pawn move is legal
        move = move.trim();
        int initial_file = move.charAt(0) - 'a';
        int initial_rank = Integer.parseInt(move.substring(1,2))-1;
    
        int final_file = move.charAt(3) - 'a';
        int final_rank = Integer.parseInt(move.substring(4, 5)) -1;
    if (Helper.isEmptySquare(final_rank, final_file)){
        if (final_file == initial_file && final_rank == initial_rank +1){
            return true;
        }
        if (final_file == initial_file && final_rank == 3 && initial_rank ==1){
            if (Helper.isEmptySquare(final_rank -1, final_file)){
                return true;
            }
            else{
                return false;
            }
        }
    }
    else{
        if (final_rank == initial_rank +1){
            if (final_file == initial_file +1 || final_file == initial_file -1){
                return Helper.isBlackPiece(final_rank, final_file);
                }
            }
        }
        
        if (Chess.EnPessantPawn != null){
        if (Chess.EnPessantPawn.pieceType == PieceType.BP){
            PieceFile EPfile = Chess.EnPessantPawn.pieceFile;
            int file = Helper.FileToInt(EPfile);
            if (initial_rank == Chess.EnPessantPawn.pieceRank -1 && final_rank == initial_rank + 1 && file == final_file ){
                return true;
            }

        }
        
    } 
        return false;

    }

    public static boolean isLegalPawnBlack(String move){ //determines if a white pawn move is legal
        move = move.trim();
        int initial_file = move.charAt(0) - 'a';
        int initial_rank = Integer.parseInt(move.substring(1,2))-1;
    
        int final_file = move.charAt(3) - 'a';
        int final_rank = Integer.parseInt(move.substring(4, 5)) -1;

    if (Helper.isEmptySquare(final_rank, final_file)){
        if (final_file == initial_file && final_rank == initial_rank -1){
            return true;
        }
        if (final_file == initial_file && final_rank == 4 && initial_rank ==6){
            if (Helper.isEmptySquare(final_rank +1, final_file)){
                return true;
            }
            else{
                return false;
            }
        }
    }
    else{
        if (final_rank == initial_rank -1){
            if (final_file == initial_file +1 || final_file == initial_file -1){
                return Helper.isWhitePiece(final_rank, final_file);
                }
            }
        }
        if (Chess.EnPessantPawn != null){
        if (Chess.EnPessantPawn.pieceType == PieceType.WP){
            PieceFile EPfile = Chess.EnPessantPawn.pieceFile;
            int file = Helper.FileToInt(EPfile);
            if (initial_rank == Chess.EnPessantPawn.pieceRank -1 && final_rank == initial_rank - 1 && file == final_file ){
                return true;
            }

        }
    }
      
        return false;

    }
    
    
    }//implement en passant and pawn promotion in these methods




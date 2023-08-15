package com.example.ukttt.strategies.winningstrategies;

import com.example.ukttt.models.Board;
import com.example.ukttt.models.Move;

public interface WinningStrategy {

	boolean checkWinner(Board board, Move move);

	void handleUndo(Board board, Move move);
}

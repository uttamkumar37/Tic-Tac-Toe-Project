package com.example.ukttt.strategies.botplayingstrategies;

import com.example.ukttt.models.Board;
import com.example.ukttt.models.Move;

public interface BotPlayingStrategy {
	Move makeMove(Board board);
}

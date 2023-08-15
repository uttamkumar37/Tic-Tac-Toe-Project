package com.example.ukttt.strategies.botplayingstrategies;

import java.util.List;

import com.example.ukttt.models.Board;
import com.example.ukttt.models.Cell;
import com.example.ukttt.models.CellState;
import com.example.ukttt.models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for (List<Cell> row: board.getBoard()) {
            for (Cell cell: row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(
                            cell,
                            null
                    );
                }
            }
        }
        return null;
    }
}

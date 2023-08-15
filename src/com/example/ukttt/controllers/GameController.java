package com.example.ukttt.controllers;

import java.util.List;

import com.example.ukttt.exceptions.DuplicateSymbolException;
import com.example.ukttt.exceptions.MoreThanOneBotException;
import com.example.ukttt.exceptions.PlayersCountDimensionMismatchException;
import com.example.ukttt.models.Game;
import com.example.ukttt.models.GameState;
import com.example.ukttt.models.Player;
import com.example.ukttt.strategies.winningstrategies.WinningStrategy;

public class GameController {

    public Game startGame(int dimensionOfBoard,
                   List<Player> players,
                   List<WinningStrategy> winningStrategies) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
//        Game.Builder.setPlayers(....)
//        .setWinningStrategies(...)
//        .build();
//
//        Game.Builder.addPlayer(..).addPlayer(..)
//        .addWinningStrategy().build();

        return Game.getBuilder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .setDimension(dimensionOfBoard)
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {
        game.undo();
    }
}

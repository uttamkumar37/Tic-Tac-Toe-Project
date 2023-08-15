import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.ukttt.controllers.GameController;
import com.example.ukttt.exceptions.DuplicateSymbolException;
import com.example.ukttt.exceptions.MoreThanOneBotException;
import com.example.ukttt.exceptions.PlayersCountDimensionMismatchException;
import com.example.ukttt.models.Bot;
import com.example.ukttt.models.BotDifficultyLevel;
import com.example.ukttt.models.Game;
import com.example.ukttt.models.GameState;
import com.example.ukttt.models.Player;
import com.example.ukttt.models.PlayerType;
import com.example.ukttt.models.Symbol;
import com.example.ukttt.strategies.winningstrategies.ColWinningStrategy;
import com.example.ukttt.strategies.winningstrategies.DiagonalWinningStrategy;
import com.example.ukttt.strategies.winningstrategies.RowWinningStrategy;
import com.example.ukttt.strategies.winningstrategies.WinningStrategy;

public class Main {
	public static void main(String[] args)
			throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
		GameController gameController = new GameController();
		try (Scanner scanner = new Scanner(System.in)) {
			try {
				int dimensionOfGame = 3;

				List<Player> players = new ArrayList<>();
				players.add(new Player(1L, "Uttam", new Symbol('X'), PlayerType.HUMAN));

				players.add(new Bot(2L, "BOT", new Symbol('O'), BotDifficultyLevel.HARD));

				List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColWinningStrategy(),
						new DiagonalWinningStrategy());

				Game game = gameController.startGame(dimensionOfGame, players, winningStrategies);

				while (gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
					// 1. printBoard
					// 2. x's turn
					// 3. ask to makeMove

					gameController.printBoard(game);

					System.out.println("Does anyone want to undo? (y/n)");
					String undoAnswer = scanner.next();

					if (undoAnswer.equalsIgnoreCase("y")) {
						gameController.undo(game);
						continue;
					}

					gameController.makeMove(game);
				}

				System.out.println("Game is finished");
				GameState state = gameController.checkState(game);

				if (state.equals(GameState.DRAW)) {
					System.out.println("It is a draw");
				} else {
					System.out.println("Winner is " + gameController.getWinner(game).getName());
				}

			} catch (Exception e) {
				throw e;
			}
		} catch (DuplicateSymbolException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

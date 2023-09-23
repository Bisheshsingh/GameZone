package com.example.games.LLD.TicTacToe.Activity;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType;
import com.example.games.LLD.TicTacToe.Factory.TicTacToePlayerFactory;
import com.example.games.LLD.TicTacToe.Models.*;
import com.example.games.Models.Coordinate2D;
import com.example.games.Models.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicTacToeApiImpl implements TicTacToeApi {
    @Autowired
    private TicTacToePlayerFactory playerFactory;
    @Autowired
    private TicTacToeEvaluation evaluation;

    @Override
    public TicTacToeBoard getEmptyBoard() {
        return new TicTacToeBoard();
    }

    @Override
    public GameStatus gameStatus(final TicTacToeBoard board,
                                 final TicTacToePlayerManager playerManager) {
        return evaluation.gameStatus(board, playerManager);
    }

    @Override
    public void makeMove(final Integer x, final Integer y,
                         final TicTacToeBoard board,
                         final TicTacToePlayerManager playerManager) {
        final TicTacToeMove move = new TicTacToeMove(new Coordinate2D(x, y),
                playerManager.currentPlayer().getCharacter());
        playerManager.nextPlayer();
        board.applyMove(move);
    }

    @Override
    public TicTacToePlayerManager getPlayerManager(final TicTacToePlayerType playerType1,
                                                   final TicTacToePlayerType playerType2) {
        final TicTacToePlayer player1 = playerFactory.getPlayer(playerType1,
                Enums.TicTacToePlayerNames.DEFAULT_PLAYER_1, Enums.TicTacToeCharacters.X);
        final TicTacToePlayer player2 = playerFactory.getPlayer(playerType2,
                Enums.TicTacToePlayerNames.DEFAULT_PLAYER_2, Enums.TicTacToeCharacters.O);

        return new TicTacToePlayerManager(List.of(player1, player2));
    }
}

package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType;

public interface TicTacToeApi {
    TicTacToeBoard getEmptyBoard();

    Boolean isGameOver(TicTacToeBoard board);

    void makeMove(Integer x, Integer y, TicTacToeBoard board,
                  TicTacToePlayerManager playerManager);

    TicTacToePlayerManager getPlayerManager(TicTacToePlayerType player1,
                                            TicTacToePlayerType player2);
}

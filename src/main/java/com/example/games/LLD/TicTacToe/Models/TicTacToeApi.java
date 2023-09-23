package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Activity.TicTacToeBoard;
import com.example.games.LLD.TicTacToe.Activity.TicTacToePlayerManager;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType;
import com.example.games.Models.GameStatus;

public interface TicTacToeApi {
    TicTacToeBoard getEmptyBoard();

    GameStatus gameStatus(TicTacToeBoard board, TicTacToePlayerManager playerManager);

    void makeMove(Integer x, Integer y, TicTacToeBoard board,
                  TicTacToePlayerManager playerManager);

    TicTacToePlayerManager getPlayerManager(TicTacToePlayerType player1,
                                            TicTacToePlayerType player2);
}

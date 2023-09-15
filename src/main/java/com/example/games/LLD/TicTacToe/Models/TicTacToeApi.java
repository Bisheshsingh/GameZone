package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType;

import java.util.List;

public interface TicTacToeApi {
    TicTacToeBoard getEmptyBoard();
    Boolean isGameOver(TicTacToeBoard board);
    void makeMove(Integer x, Integer y, Enums.TicTacToeCharacters character,
                  TicTacToeBoard board);
    TicTacToePlayer getPlayer(TicTacToePlayerType type, String name,
                              Enums.TicTacToeCharacters character);

    TicTacToePlayerManager getPlayerManager(List<TicTacToePlayer> players);
}

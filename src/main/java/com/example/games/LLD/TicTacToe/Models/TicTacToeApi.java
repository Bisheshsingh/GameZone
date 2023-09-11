package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType;
import com.example.games.Models.Coordinate2D;

public interface TicTacToeApi {
    TicTacToeBoard getEmptyBoard();
    Boolean isGameOver(TicTacToeBoard board);
    void makeMove(Integer x, Integer y, Enums.TicTacToeCharacters character,
                  TicTacToeBoard board);
    TicTacToePlayer getPlayer(TicTacToePlayerType type, String name,
                              Enums.TicTacToeCharacters character);
}

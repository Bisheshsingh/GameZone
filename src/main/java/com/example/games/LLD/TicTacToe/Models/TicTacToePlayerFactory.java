package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;

public interface TicTacToePlayerFactory {
    TicTacToePlayer getPlayer(Enums.TicTacToePlayerType type,
                              String name, Enums.TicTacToeCharacters character);
}

package com.example.games.LLD.TicTacToe.Factory;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Models.TicTacToePlayer;

public interface TicTacToePlayerFactory {
    TicTacToePlayer getPlayer(Enums.TicTacToePlayerType type,
                              Enums.TicTacToePlayerNames name, Enums.TicTacToeCharacters character);
}

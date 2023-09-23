package com.example.games.LLD.TicTacToe.Activity;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Models.TicTacToePlayer;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TicTacToeHumanPlayer extends TicTacToePlayer {
    public TicTacToeHumanPlayer(final String id, final Enums.TicTacToePlayerNames name, final Enums.TicTacToeCharacters character) {
        super(id, name, character);
    }
}

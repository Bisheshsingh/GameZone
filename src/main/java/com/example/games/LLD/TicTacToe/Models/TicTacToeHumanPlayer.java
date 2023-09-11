package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicTacToeHumanPlayer extends TicTacToePlayer {
    private final Enums.TicTacToeCharacters character;

    public TicTacToeHumanPlayer(final String id, final String name, final Enums.TicTacToeCharacters character) {
        super(id, name);
        this.character = character;
    }

    @Override
    public TicTacToeMove makeMove() {
        return null;
    }
}

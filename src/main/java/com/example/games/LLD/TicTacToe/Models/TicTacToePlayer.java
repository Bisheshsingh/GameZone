package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.Models.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class TicTacToePlayer extends Player {
    private final Enums.TicTacToeCharacters character;

    public TicTacToePlayer(final String id, final String name,
                           final Enums.TicTacToeCharacters character) {
        super(id, name);
        this.character = character;
    }
}

package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.Models.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TicTacToePlayer extends Player {
    protected Enums.TicTacToeCharacters character;

    public TicTacToePlayer(final String id, final Enums.TicTacToePlayerNames name,
                           final Enums.TicTacToeCharacters character) {
        super(id, name.getName());
        this.character = character;
    }
}

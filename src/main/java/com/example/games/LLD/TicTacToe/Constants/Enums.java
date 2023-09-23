package com.example.games.LLD.TicTacToe.Constants;

import lombok.Getter;
import lombok.ToString;

public class Enums {
    public enum TicTacToePlayerType {
        HUMAN_PLAYER;
    }

    @Getter
    @ToString
    public enum TicTacToeCharacters {
        DEFAULT_CHAR(' '), O('O'), X('X');

        private final Character character;

        TicTacToeCharacters(final Character character) {
            this.character = character;
        }
    }

    @Getter
    @ToString
    public enum TicTacToePlayerNames {
        DEFAULT_PLAYER_1("Player 1"), DEFAULT_PLAYER_2("Player 2");

        private final String name;

        TicTacToePlayerNames(final String name) {
            this.name = name;
        }
    }
}

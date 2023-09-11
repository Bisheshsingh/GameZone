package com.example.games.LLD.TicTacToe.Constants;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

public class Enums {
    public enum TicTacToePlayerType{
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
}

package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.Models.Cell;
import com.example.games.Models.Coordinate2D;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TicTacToeCell extends Cell<Coordinate2D, Enums.TicTacToeCharacters> {
    public TicTacToeCell(final Coordinate2D key, final Enums.TicTacToeCharacters value) {
        super(key, value);
    }
}

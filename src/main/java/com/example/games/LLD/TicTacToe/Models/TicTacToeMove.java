package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.Models.BiDirectionMove;
import com.example.games.Models.Coordinate2D;

public class TicTacToeMove extends BiDirectionMove<Enums.TicTacToeCharacters> {

    public TicTacToeMove(final Coordinate2D coordinates, final Enums.TicTacToeCharacters value) {
        super(coordinates, value);
    }
}

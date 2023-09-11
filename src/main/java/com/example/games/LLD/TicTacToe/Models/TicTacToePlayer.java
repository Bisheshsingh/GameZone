package com.example.games.LLD.TicTacToe.Models;

import com.example.games.Models.Player;

public abstract class TicTacToePlayer extends Player<TicTacToeMove> {
    public TicTacToePlayer(final String id, final String name) {
        super(id, name);
    }
}

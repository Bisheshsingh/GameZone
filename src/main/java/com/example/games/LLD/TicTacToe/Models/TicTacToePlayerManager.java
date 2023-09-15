package com.example.games.LLD.TicTacToe.Models;


import com.example.games.Models.PlayerManager;

import java.util.List;

public class TicTacToePlayerManager extends PlayerManager<TicTacToePlayer> {
    private static final Integer DEFAULT_INDEX = 0;
    private Integer index;

    private void incrementIndex() {
        index = index + 1;
        index = index % players.size();
    }

    public TicTacToePlayerManager(final List<TicTacToePlayer> players) {
        super(players);
        this.index = 0;
    }

    @Override
    public TicTacToePlayer currentPlayer() {
        return players.get(index);
    }

    @Override
    public TicTacToePlayer nextPlayer() {
        incrementIndex();
        return currentPlayer();
    }
}

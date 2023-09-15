package com.example.games.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public abstract class PlayerManager<T extends Player> {
    protected List<T> players;

    public void addPlayer(final T player) {
        players.add(player);
    }

    public T getPlayer(final Integer index) {
        return players.get(index);
    }

    public abstract T currentPlayer();

    public abstract T nextPlayer();
}

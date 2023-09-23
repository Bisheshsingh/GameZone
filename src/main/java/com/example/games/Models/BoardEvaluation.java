package com.example.games.Models;

public interface BoardEvaluation<T extends Board<?, ?>, U extends PlayerManager<?>> {
    GameStatus gameStatus(T board, U playerManager);
}

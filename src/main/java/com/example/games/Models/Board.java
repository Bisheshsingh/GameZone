package com.example.games.Models;

public interface Board <U extends Cell<?>, V extends Move> {
    void applyMove(V move);
}

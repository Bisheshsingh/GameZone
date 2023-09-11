package com.example.games.Models;

public interface Board <T extends Move> {
    void applyMove(T move);
}

package com.example.games.Models;

import lombok.Data;

@Data
public abstract class Player <T extends Move> {
    private final String id;
    private final String name;

    public abstract T makeMove();
}

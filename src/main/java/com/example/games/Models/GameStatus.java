package com.example.games.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameStatus {
    private Boolean isGameOver;
    private Player winner;
}

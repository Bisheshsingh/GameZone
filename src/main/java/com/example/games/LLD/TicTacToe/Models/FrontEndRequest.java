package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Activity.TicTacToeBoard;
import com.example.games.LLD.TicTacToe.Activity.TicTacToePlayerManager;
import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.Models.GameStatus;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FrontEndRequest {
    private final Gson objectParser;
    private final TicTacToeBoard board;
    private final TicTacToePlayerManager playerManager;
    private final Enums.TicTacToeCharacters defaultCharacter;
    private final GameStatus gameStatus;
}

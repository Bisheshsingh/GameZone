package com.example.games.LLD.TicTacToe.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FrontEndResponse {
    private String board;
    private String playerManager;
    private Integer x;
    private Integer y;
}

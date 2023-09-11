package com.example.games.LLD.TicTacToe.Activity;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType;
import com.example.games.LLD.TicTacToe.Models.*;
import com.example.games.Models.Coordinate2D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicTacToeApiImpl implements TicTacToeApi {
    @Autowired
    private TicTacToePlayerFactory playerFactory;

    @Override
    public TicTacToeBoard getEmptyBoard() {
        return new TicTacToeBoard();
    }

    @Override
    public Boolean isGameOver(final TicTacToeBoard board) {
        return Boolean.FALSE;
    }

    @Override
    public void makeMove(final Integer x, final Integer y, final Enums.TicTacToeCharacters character,
                         final TicTacToeBoard board) {
        final TicTacToeMove move = new TicTacToeMove(new Coordinate2D(x,y) , character);

        board.applyMove(move);
    }

    @Override
    public TicTacToePlayer getPlayer(final TicTacToePlayerType type, final String name,
                                     final Enums.TicTacToeCharacters character) {
        return playerFactory.getPlayer(type, name, character);
    }
}

package com.example.games.LLD.TicTacToe.Models;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.Models.Board2D;
import com.example.games.Models.Coordinate2D;
import lombok.Getter;
import lombok.Setter;

import static com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToeCharacters.DEFAULT_CHAR;
import static com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToeCharacters;

@Getter
@Setter
public class TicTacToeBoard extends Board2D<TicTacToeCharacters, TicTacToeCell, TicTacToeMove> {
    private static final Integer DEFAULT_ROWS = 3;
    private static final Integer DEFAULT_COLUMNS = 3;

    private void initialize(final Enums.TicTacToeCharacters value) {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                final TicTacToeCell cell = new TicTacToeCell(value);
                this.rawBoard.get(i).set(j, cell);
            }
        }
    }

    public TicTacToeBoard() {
        super(DEFAULT_ROWS, DEFAULT_COLUMNS);
        initialize(DEFAULT_CHAR);
    }

    public TicTacToeBoard(final Integer rows, final Integer columns,
                          final Enums.TicTacToeCharacters defaultValue) {
        super(rows, columns);
        initialize(defaultValue);
    }

    @Override
    public void applyMove(final TicTacToeMove move) {
        this.getRawBoard()
                .get(move.getCoordinates().getX())
                .get(move.getCoordinates().getY())
                .setValue(move.getValue());
    }
}

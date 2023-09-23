package com.example.games.LLD.TicTacToe.Activity;

import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Models.TicTacToeCell;
import com.example.games.LLD.TicTacToe.Models.TicTacToePlayer;
import com.example.games.Models.Board2DEvaluation;
import com.example.games.Models.GameStatus;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class TicTacToeEvaluation
        extends Board2DEvaluation<TicTacToeBoard, TicTacToePlayerManager> {
    private Boolean rowEvaluation(final TicTacToeBoard board) {
        for (int row = 0; row < board.getRows(); row++) {
            final TicTacToeCell firstCell = board.getCell(row, 0);

            if (firstCell.getValue().equals(Enums.TicTacToeCharacters.DEFAULT_CHAR)) {
                continue;
            }

            final boolean isRowEqual = board.getCell(row)
                    .stream().allMatch(cell -> cell.equals(firstCell));

            if (isRowEqual) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    private Boolean diagonalEvaluation(final TicTacToeBoard board) {
        int row = 0, column = 0;
        TicTacToeCell firstCell = board.getCell(row, column);
        boolean isDiagonal1 = Boolean.TRUE;
        boolean isDiagonal2 = Boolean.TRUE;

        if (!firstCell.getValue().equals(Enums.TicTacToeCharacters.DEFAULT_CHAR)) {

            while (row < board.getRows() && column < board.getColumns()) {
                if (!board.getCell(row, column).getValue()
                        .equals(firstCell.getValue())) {
                    isDiagonal1 = Boolean.FALSE;
                    break;
                }

                row++;
                column++;
            }
        } else {
            isDiagonal1 = Boolean.FALSE;
        }

        row = 0;
        column = board.getColumns() - 1;
        firstCell = board.getCell(row, column);

        if (!firstCell.getValue().equals(Enums.TicTacToeCharacters.DEFAULT_CHAR)) {

            while (column >= 0 && row < board.getRows()) {
                if (!board.getCell(row, column).getValue()
                        .equals(firstCell.getValue())) {
                    isDiagonal2 = Boolean.FALSE;
                    break;
                }

                row++;
                column--;
            }
        } else {
            isDiagonal2 = Boolean.FALSE;
        }

        return isDiagonal1 | isDiagonal2;
    }

    private Boolean columnEvaluation(final TicTacToeBoard board) {
        for (int column = 0; column < board.getColumns(); column++) {
            final TicTacToeCell firstCell = board.getCell(0, column);

            if (firstCell.getValue().equals(Enums.TicTacToeCharacters.DEFAULT_CHAR)) {
                continue;
            }

            final Integer columnF = column;
            final boolean isColumnEqual = IntStream
                    .iterate(0, i -> i + 1)
                    .limit(board.getRows())
                    .allMatch(row -> board.getCell(row, columnF).equals(firstCell));

            if (isColumnEqual) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    @Override
    public GameStatus gameStatus(final TicTacToeBoard board,
                                 final TicTacToePlayerManager playerManager) {
        final Boolean isGameOver = rowEvaluation(board)
                | columnEvaluation(board)
                | diagonalEvaluation(board);
        final TicTacToePlayer winner = isGameOver ?
                playerManager.getPlayer(1 - playerManager.getIndex()) : null;

        return GameStatus.builder()
                .isGameOver(isGameOver)
                .winner(winner)
                .build();
    }
}

package com.example.games.LLD.TicTacToe.Factory;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Activity.TicTacToeHumanPlayer;
import com.example.games.LLD.TicTacToe.Models.TicTacToePlayer;
import org.springframework.stereotype.Component;

import static com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType.*;

@Component
public class TicTacToePlayerFactoryImpl implements TicTacToePlayerFactory {

    @Override
    public TicTacToePlayer getPlayer(final Enums.TicTacToePlayerType type,
                                     final Enums.TicTacToePlayerNames name, final Enums.TicTacToeCharacters character) {
        if (type.equals(HUMAN_PLAYER)) {
            return new TicTacToeHumanPlayer(
                    String.valueOf(RandomUtil.getPositiveInt()),
                    name, character
            );
        }

        return null;
    }
}

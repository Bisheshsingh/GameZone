package com.example.games.HLD.TicTacToe;

import com.example.games.Constants.Constant;
import com.example.games.LLD.TicTacToe.Constants.Enums;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToeCharacters;
import com.example.games.LLD.TicTacToe.Constants.TicTacToeAttributes;
import com.example.games.LLD.TicTacToe.Models.TicTacToeApi;
import com.example.games.LLD.TicTacToe.Models.TicTacToeBoard;
import com.example.games.LLD.TicTacToe.Models.TicTacToePlayer;
import com.example.games.LLD.TicTacToe.Models.TicTacToePlayerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({
        TicTacToeAttributes.BOARD,
        TicTacToeAttributes.PLAYER_MANAGER,
        TicTacToeAttributes.DEFAULT_CHARACTER})
public class TicTacToeLiveController {
    @Autowired
    private TicTacToeApi api;

    @GetMapping(value = "/tictactoe/vsplayer")
    public String vsPlayer(Model model) {
        model.addAttribute(TicTacToeAttributes.BOARD, api.getEmptyBoard());
        model.addAttribute(TicTacToeAttributes.DEFAULT_CHARACTER,
                TicTacToeCharacters.DEFAULT_CHAR);

        final TicTacToePlayer player1 = api.getPlayer(
                Enums.TicTacToePlayerType.HUMAN_PLAYER,
                TicTacToeAttributes.DEFAULT_PLAYER_1,
                TicTacToeCharacters.X);
        final TicTacToePlayer player2 = api.getPlayer(
                Enums.TicTacToePlayerType.HUMAN_PLAYER,
                TicTacToeAttributes.DEFAULT_PLAYER_2,
                TicTacToeCharacters.O);
        final TicTacToePlayerManager playerManager = api.getPlayerManager(
               List.of(player1, player2)
        );

        model.addAttribute(TicTacToeAttributes.PLAYER_MANAGER, playerManager);

        return "redirect:" + Constant.PageInfos.TIC_TAC_TOE_GAME.getPageLink();
    }

    @GetMapping(value = "/tictactoe/updateBoard/{x}/{y}")
    public String updateBoard(@SessionAttribute(TicTacToeAttributes.BOARD) final TicTacToeBoard board,
                              @SessionAttribute(TicTacToeAttributes.PLAYER_MANAGER) final TicTacToePlayerManager playerManager,
                              @PathVariable(TicTacToeAttributes.X) Integer x,
                              @PathVariable(TicTacToeAttributes.Y) Integer y, Model model) {

        final TicTacToePlayer player = playerManager.currentPlayer();
        api.makeMove(x, y, player.getCharacter(), board);
        playerManager.nextPlayer();

        return "redirect:" + Constant.PageInfos.TIC_TAC_TOE_GAME.getPageLink();
    }
}

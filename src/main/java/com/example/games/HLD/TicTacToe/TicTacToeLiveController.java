package com.example.games.HLD.TicTacToe;

import com.example.games.Constants.Constant;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToeCharacters;
import com.example.games.LLD.TicTacToe.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToePlayerType.*;

@Controller
public class TicTacToeLiveController {
    @Autowired
    private TicTacToeApi api;

    @GetMapping(value = "/tictactoe/vsplayer")
    public String vsPlayer(final RedirectAttributes redirectAttributes) {
        final FrontEndRequest request = FrontEndRequest.builder()
                .defaultCharacter(TicTacToeCharacters.DEFAULT_CHAR)
                .board(api.getEmptyBoard())
                .playerManager(api.getPlayerManager(HUMAN_PLAYER, HUMAN_PLAYER))
                .objectParser(Attributes.OBJECT_PARSER)
                .build();
        final FrontEndResponse response = FrontEndResponse.builder().build();

        redirectAttributes.addFlashAttribute(Attributes.REQUEST_KEY, request);
        redirectAttributes.addFlashAttribute(Attributes.RESPONSE_KEY, response);

        return "redirect:" + Constant.PageInfos.TIC_TAC_TOE_GAME.getPageLink();
    }

    @GetMapping(value = "/tictactoe/updateBoard")
    public String updateBoard(@ModelAttribute(Attributes.RESPONSE_KEY) final FrontEndResponse response,
                              final RedirectAttributes redirectAttributes) {
        final TicTacToePlayerManager playerManager = Attributes.OBJECT_PARSER.fromJson(
                response.getPlayerManager(), TicTacToePlayerManager.class);
        final TicTacToeBoard board = Attributes.OBJECT_PARSER.fromJson(
                response.getBoard(), TicTacToeBoard.class);

        api.makeMove(response.getX(), response.getY(), board, playerManager);

        final FrontEndRequest request = FrontEndRequest.builder()
                .defaultCharacter(TicTacToeCharacters.DEFAULT_CHAR)
                .board(board)
                .playerManager(playerManager)
                .objectParser(Attributes.OBJECT_PARSER)
                .build();

        redirectAttributes.addFlashAttribute(Attributes.REQUEST_KEY, request);
        redirectAttributes.addFlashAttribute(Attributes.RESPONSE_KEY, response);

        return "redirect:" + Constant.PageInfos.TIC_TAC_TOE_GAME.getPageLink();
    }
}

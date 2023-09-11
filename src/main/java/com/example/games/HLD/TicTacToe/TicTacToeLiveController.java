package com.example.games.HLD.TicTacToe;

import com.example.games.Constants.Constant;
import com.example.games.LLD.TicTacToe.Constants.Enums.TicTacToeCharacters;
import com.example.games.LLD.TicTacToe.Constants.TicTacToeAttributes;
import com.example.games.LLD.TicTacToe.Models.TicTacToeApi;
import com.example.games.LLD.TicTacToe.Models.TicTacToeBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({
        TicTacToeAttributes.BOARD,
        TicTacToeAttributes.DEFAULT_CHARACTER})
public class TicTacToeLiveController {
    @Autowired
    private TicTacToeApi api;

    @GetMapping(value = "/tictactoe/vsplayer")
    public String vsPlayer(Model model) {
        model.addAttribute(TicTacToeAttributes.BOARD, api.getEmptyBoard());
        model.addAttribute(TicTacToeAttributes.DEFAULT_CHARACTER,
                TicTacToeCharacters.DEFAULT_CHAR);

        return "redirect:" + Constant.PageInfos.TIC_TAC_TOE_GAME.getPageLink();
    }

    @GetMapping(value = "/tictactoe/updateBoard/{x}/{y}")
    public String updateBoard(@SessionAttribute(TicTacToeAttributes.BOARD) final TicTacToeBoard board,
                              @PathVariable(TicTacToeAttributes.X) Integer x,
                              @PathVariable(TicTacToeAttributes.Y) Integer y, Model model) {
        api.makeMove(x, y, TicTacToeCharacters.X, board);

        return "redirect:" + Constant.PageInfos.TIC_TAC_TOE_GAME.getPageLink();
    }
}

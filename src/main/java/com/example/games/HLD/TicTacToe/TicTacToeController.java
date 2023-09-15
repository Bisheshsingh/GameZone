package com.example.games.HLD.TicTacToe;

import com.example.games.Constants.Constant;
import com.example.games.LLD.TicTacToe.Constants.TicTacToeAttributes;
import com.example.games.Models.WebPageController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({
        TicTacToeAttributes.BOARD,
        TicTacToeAttributes.PLAYER_MANAGER,
        TicTacToeAttributes.DEFAULT_CHARACTER})
public class TicTacToeController implements WebPageController {
    @Override
    @GetMapping(value = "/tictactoe")
    public String welcomePage(Model model) {
        return Constant.PageInfos.TIC_TAC_TOE_MENU.getPageName();
    }

    @GetMapping(value = "tictactoe/game")
    public String game(Model model) {
        if (!model.containsAttribute(TicTacToeAttributes.BOARD)) {
            return Constant.PageInfos.TIC_TAC_TOE_MENU.getPageName();
        }

        return Constant.PageInfos.TIC_TAC_TOE_GAME.getPageName();
    }
}

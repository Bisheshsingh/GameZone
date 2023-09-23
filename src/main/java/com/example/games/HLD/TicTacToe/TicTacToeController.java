package com.example.games.HLD.TicTacToe;

import com.example.games.Constants.Constant;
import com.example.games.Models.WebPageController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicTacToeController implements WebPageController {
    @Override
    @GetMapping(value = "/tictactoe")
    public String welcomePage(Model model) {
        return Constant.PageInfos.TIC_TAC_TOE_MENU.getPageName();
    }

    @GetMapping(value = "tictactoe/game")
    public String game(Model model) {
        if (!model.containsAttribute(Attributes.RESPONSE_KEY)) {
            return Constant.PageInfos.TIC_TAC_TOE_MENU.getPageName();
        }

        return Constant.PageInfos.TIC_TAC_TOE_GAME.getPageName();
    }
}

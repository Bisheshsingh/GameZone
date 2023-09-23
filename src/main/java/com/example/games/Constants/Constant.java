package com.example.games.Constants;

import com.example.games.Models.PageInfo;

public final class Constant {
    public static final class PageInfos {
        public static final PageInfo MAIN_WELCOME_PAGE
                = new PageInfo("WelcomePage", "/");
        public static final PageInfo TIC_TAC_TOE_MENU
                = new PageInfo("TicTacToeMenu", "/tictactoe");

        public static final PageInfo TIC_TAC_TOE_GAME
                = new PageInfo("TicTacToeGame", "/tictactoe/game");

        public static final PageInfo TIC_TAC_TOE_GAME_OVER
                = new PageInfo("TicTacToeGameOver", "/tictactoe/gameover");
    }

    public static final class ImagePaths {
        public static final String TIC_TAC_TOE_ICON = "/Others/TicTacToe/tictactoeicon.png";
    }
}

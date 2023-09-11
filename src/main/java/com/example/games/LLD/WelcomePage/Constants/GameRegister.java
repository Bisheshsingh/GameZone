package com.example.games.LLD.WelcomePage.Constants;

import com.example.games.Constants.Constant;
import com.example.games.LLD.WelcomePage.Models.GamePageInfo;
import com.google.common.collect.ImmutableList;

public class GameRegister {
    public static final ImmutableList<GamePageInfo> gamePageInfos =
            ImmutableList.of(
                    new GamePageInfo("Tic-Tac-Toe",
                            Constant.ImagePaths.TIC_TAC_TOE_ICON,
                            Constant.PageInfos.TIC_TAC_TOE_MENU)
            );
}

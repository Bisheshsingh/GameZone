package com.example.games.LLD.WelcomePage.Activity;

import com.example.games.LLD.WelcomePage.Constants.GameRegister;
import com.example.games.LLD.WelcomePage.Models.API;
import com.example.games.LLD.WelcomePage.Models.GamePageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class APIImpl implements API {
    @Override
    public List<GamePageInfo> getGamesList() {
        return GameRegister.gamePageInfos;
    }
}
